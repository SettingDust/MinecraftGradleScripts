pluginManagement {
    repositories {
        maven("https://maven.neoforged.net/releases") { name = "NeoForge" }
    }
}

dependencyResolutionManagement.versionCatalogs.maybeCreate("catalog").apply {
    plugin("neoforge-gradle", "net.neoforged.gradle.userdev").version("7.+")
    plugin("neoforge-gradle-vanilla", "net.neoforged.gradle.vanilla").version("7.+")
    plugin("neoforge-gradle-mixin", "net.neoforged.gradle.mixin").version("7.+")

    // https://linkie.shedaniel.dev/dependencies?loader=neoforge
    library("neoforge", "net.neoforged", "neoforge").version("21.0.14-beta")
}

