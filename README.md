# wanted_android_plugin

![Build](https://github.com/nayunjae/wanted_android_plugin/workflows/Build/badge.svg)
[![Version](https://img.shields.io/jetbrains/plugin/v/PLUGIN_ID.svg)](https://plugins.jetbrains.com/plugin/com.github.nayunjae.wantedandroidstudioplugin)
[![Downloads](https://img.shields.io/jetbrains/plugin/d/PLUGIN_ID.svg)](https://plugins.jetbrains.com/plugin/com.github.nayunjae.wantedandroidstudioplugin)

## Template ToDo list
- [x] Create a new [IntelliJ Platform Plugin Template][template] project.
- [x] Get familiar with the [template documentation][template].
- [x] Adjust the [pluginGroup](./gradle.properties), [plugin ID](./src/main/resources/META-INF/plugin.xml) and [sources package](./src/main/kotlin).
- [x] Adjust the plugin description in `README` (see [Tips][docs:plugin-description])
- [x] Review the [Legal Agreements](https://plugins.jetbrains.com/docs/marketplace/legal-agreements.html?from=IJPluginTemplate).
- [x] [Publish a plugin manually](https://plugins.jetbrains.com/docs/intellij/publishing-plugin.html?from=IJPluginTemplate) for the first time.
- [x] Set the `PLUGIN_ID` in the above README badges.
- [x] Set the [Plugin Signing](https://plugins.jetbrains.com/docs/intellij/plugin-signing.html?from=IJPluginTemplate) related [secrets](https://github.com/JetBrains/intellij-platform-plugin-template#environment-variables).
- [x] Set the [Deployment Token](https://plugins.jetbrains.com/docs/marketplace/plugin-upload.html?from=IJPluginTemplate).
- [x] Click the <kbd>Watch</kbd> button on the top of the [IntelliJ Platform Plugin Template][template] to be notified about releases containing new features and fixes.

<!-- Plugin description -->

Add support for creating templates for Compose and packages for clean architecture.
Suitable for Wanted projects.

## How to use it
Select Settings → Plugins → Install Plugins from Disk to add.

### Adding Packages
- new → Other → Wanted Clean Architecture Package

### Add Compose File
- new → Other → Wanted Compose

원티드 Android Studio 플러그인 입니다. 
Compose 용 템플릿을 생성할 수 있으며, clean architecture를 위한 패키지를 생성할 수 있습니다.

## 사용방법
Settings → Plugins → Install Plugin from Disk 를 선택해서 추가합니다.

### 패캐지 추가
- new → Other → Wanted Clean Architecture Package

### Compose 파일 추가
- new → Other → Wanted Compose

<!-- Plugin description end -->

## Installation

- Using the IDE built-in plugin system:

  <kbd>Settings/Preferences</kbd> > <kbd>Plugins</kbd> > <kbd>Marketplace</kbd> > <kbd>Search for "wanted_android_plugin"</kbd> >
  <kbd>Install</kbd>

- Manually:

  Download the [latest release](https://github.com/nayunjae/wanted_android_plugin/releases/latest) and install it manually using
  <kbd>Settings/Preferences</kbd> > <kbd>Plugins</kbd> > <kbd>⚙️</kbd> > <kbd>Install plugin from disk...</kbd>


---
Plugin based on the [IntelliJ Platform Plugin Template][template].

[template]: https://github.com/JetBrains/intellij-platform-plugin-template
[docs:plugin-description]: https://plugins.jetbrains.com/docs/intellij/plugin-user-experience.html#plugin-description-and-presentation
