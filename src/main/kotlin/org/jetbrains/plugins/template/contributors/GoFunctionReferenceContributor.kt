
package org.jetbrains.plugins.template.contributors

import com.goide.GoFileType
import com.goide.psi.*
import com.intellij.openapi.diagnostic.Logger
import com.intellij.openapi.util.TextRange
import com.intellij.patterns.PlatformPatterns
import com.intellij.patterns.StandardPatterns
import com.intellij.psi.*
import com.intellij.psi.search.FileTypeIndex
import com.intellij.psi.search.GlobalSearchScope
import com.intellij.psi.util.PsiTreeUtil
import com.intellij.util.ProcessingContext

class GoFunctionReferenceContributor : PsiReferenceContributor() {
    private val LOG = Logger.getInstance(GoFunctionReferenceContributor::class.java)

    override fun registerReferenceProviders(registrar: PsiReferenceRegistrar) {
        LOG.warn("GoFunctionReferenceContributor: registerReferenceProviders called")

        val literalInRequestReplyCall = PlatformPatterns.psiElement(PsiElement::class.java)
            .withParent(GoArgumentList::class.java)
            .withAncestor(
                2, // GoLiteral -> GoArgumentList -> GoCallExpr
                PlatformPatterns.psiElement(GoCallExpr::class.java)
                    .withChild(PlatformPatterns.psiElement(GoReferenceExpression::class.java)
                        .withText(StandardPatterns.string().endsWith("RequestReply"))
                    )
            )

        registrar.registerReferenceProvider(
            literalInRequestReplyCall,
            object : PsiReferenceProvider() {
                override fun getReferencesByElement(
                    element: PsiElement,
                    context: ProcessingContext
                ): Array<PsiReference> {
                    LOG.warn("getReferencesByElement called for element: ${element.javaClass.name}")
                    if (element !is GoStringLiteral) {
                        LOG.warn("  Element is not GoStringLiteral. Returning EMPTY_ARRAY.")
                        return PsiReference.EMPTY_ARRAY
                    }
                    LOG.warn("  Element is GoStringLiteral. Value: ${element.text}")
                    val callExpr = element.parent?.parent as? GoCallExpr
                    if (callExpr != null) {
                        LOG.warn("  Found GoCallExpr: ${callExpr.text}")
                        val callReference = callExpr.expression as? GoReferenceExpression
                        if (callReference != null && callReference.text.endsWith("RequestReply")) {
                            LOG.warn("  Call reference ends with RequestReply. Call text: ${callReference.text}")
                            val functionName = element.decodedText
                            LOG.warn("  Extracted function name: $functionName")
                            return arrayOf(GoFunctionReference(element, functionName))
                        }
                        LOG.warn("  Call reference does not end with RequestReply or is null.")
                    }
                    LOG.warn("  Call expression is null. Returning EMPTY_ARRAY.")
                    return PsiReference.EMPTY_ARRAY
                }
            }
        )
    }
}

class GoFunctionReference(element: PsiElement, private val functionName: String) :
    PsiReferenceBase<PsiElement>(element, TextRange(1, functionName.length + 1)) {

    private val LOG = Logger.getInstance(GoFunctionReference::class.java)

    override fun resolve(): PsiElement? {
        val project = element.project
        val scope = GlobalSearchScope.projectScope(project)
        var resolvedElement: PsiElement? = null

        LOG.warn("Attempting to resolve function: $functionName")

        FileTypeIndex.getFiles(GoFileType.INSTANCE, scope).forEach { virtualFile ->
            val psiFile = PsiManager.getInstance(project).findFile(virtualFile)
            if (psiFile is GoFile) {
                LOG.warn("Searching in file: ${psiFile.name}")
                val functions = PsiTreeUtil.findChildrenOfType(psiFile, GoFunctionOrMethodDeclaration::class.java)
                for (function in functions) {
                    LOG.warn("  Found function: ${function.name}")
                    if (function.name == functionName) {
                        resolvedElement = function
                        return@forEach // Found, stop iterating files
                    }
                }
            }
        }
        LOG.warn("Resolved element: $resolvedElement")
        return resolvedElement
    }

    override fun getVariants(): Array<Any> = emptyArray()
}
