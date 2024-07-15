pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositories {
        maven("https://api.modrinth.com/maven") { content { includeGroup("maven.modrinth") } }
    }
}

val minecraft: String by settings.extra

dependencyResolutionManagement.versionCatalogs.maybeCreate("catalog").apply {
    version("minecraft", minecraft)

    // https://plugins.gradle.org/plugin/org.jetbrains.gradle.plugin.idea-ext
    plugin("idea-ext", "org.jetbrains.gradle.plugin.idea-ext").version("1.+")

    // https://github.com/palantir/gradle-git-version
    plugin("git-version", "com.palantir.git-version").version("3.+")

    plugin("shadow", "io.github.goooler.shadow").version("8.+")
}
