pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()
    }
}

dependencyResolutionManagement.versionCatalogs.maybeCreate("catalog").apply {
    // https://plugins.gradle.org/plugin/org.jetbrains.gradle.plugin.idea-ext
    plugin("idea-ext", "org.jetbrains.gradle.plugin.idea-ext").version("1.+")

    // https://github.com/palantir/gradle-git-version
    plugin("git-version", "com.palantir.git-version").version("3.+")

    plugin("shadow", "io.github.goooler.shadow").version("8.+")
}
