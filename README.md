# 🚀 GoLand Polycode Navigator

<!-- Plugin description -->
## ✨ Overview

The **GoLand Polycode Navigator** is an innovative IntelliJ Platform plugin designed to enhance navigation within polyglot GoLand projects. It provides seamless and intuitive ways to explore codebases that combine Go with other languages, making development smoother and more efficient.

Say goodbye to the hassle of jumping between different tools or manually searching for related code. This plugin intelligently understands your project's structure, allowing you to navigate across language boundaries with ease.
<!-- Plugin description end -->

## 🌟 Features

-   **Intelligent Code Awareness**: Understands the relationships between different parts of your polycode project, providing relevant navigation suggestions.
-   **Enhanced Productivity**: Reduce context switching and accelerate your development workflow in complex, multi-language GoLand projects.
-   **Modern UI Integration**: Seamlessly integrates with the GoLand IDE, offering a clean and intuitive user experience.

## 🚀 Getting Started

### Installation

1.  **Via JetBrains Marketplace (Recommended)**:
    *   Open GoLand.
    *   Go to `Settings/Preferences` > `Plugins`.
    *   Search for "GoLand Polycode Navigator" in the Marketplace tab.
    *   Click `Install` and restart the IDE.

2.  **Manual Installation**:
    *   Download the latest `.zip` release from the [releases page](https://github.com/JetBrains/intellij-platform-plugin-template/releases).
    *   Open GoLand.
    *   Go to `Settings/Preferences` > `Plugins`.
    *   Click the ⚙️ icon (gear) and select `Install Plugin from Disk...`.
    *   Select the downloaded `.zip` file and restart the IDE.

### Usage

Once installed, the GoLand Polycode Navigator works in the background to enhance your navigation experience.

*   **Contextual Navigation**: When working in a Go file, use standard navigation shortcuts (e.g., `Ctrl+B` / `Cmd+B` for Go to Definition) on elements that have cross-language references. The plugin will intelligently suggest or directly navigate to the corresponding definition in another language.
*   **Polycode Search**: Utilize the enhanced search capabilities to find usages or declarations across your entire polycode project, regardless of the language.

More detailed usage instructions and examples will be provided in future updates.

## 🤝 Contributing

We welcome contributions to the GoLand Polycode Navigator! If you have ideas for new features, bug fixes, or improvements, please feel free to:

1.  Fork the repository.
2.  Create a new branch (`git checkout -b feature/your-feature`).
3.  Make your changes.
4.  Commit your changes (`git commit -m 'feat: Add new feature'`).
5.  Push to the branch (`git push origin feature/your-feature`).
6.  Open a Pull Request.

Please ensure your code adheres to the project's coding standards and includes appropriate tests.

## 📄 License

This project is licensed under the [MIT License](LICENSE).

## 🔗 Useful Links

*   [IntelliJ Platform SDK Plugin SDK][docs]
*   [IntelliJ Platform Gradle Plugin Documentation][gh:intellij-platform-gradle-plugin-docs]
*   [JetBrains Marketplace](https://plugins.jetbrains.com)

[docs]: https://plugins.jetbrains.com/docs/intellij?from=IJPluginTemplate
[gh:build]: https://github.com/JetBrains/intellij-platform-plugin-template/actions?query=workflow%3ABuild
[gh:intellij-platform-gradle-plugin-docs]: https://plugins.jetbrains.com/docs/intellij/tools-intellij-platform-gradle-plugin.html
[jb:github]: https://github.com/JetBrains/.github/blob/main/profile/README.md
[jb:slack]: https://plugins.jetbrains.com/slack
[jb:twitter]: https://twitter.com/JBPlatform

[file:intellij-platform-plugin-template-dark]: ./.github/readme/intellij-platform-plugin-template-dark.svg#gh-dark-mode-only
[file:intellij-platform-plugin-template-light]: ./.github/readme/intellij-platform-plugin-template-light.svg#gh-light-mode-only