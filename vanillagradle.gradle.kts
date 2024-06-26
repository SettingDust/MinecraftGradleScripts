pluginManagement {
    repositories {
        maven("https://repo.spongepowered.org/repository/maven-public/")
    }
}

dependencyResolutionManagement {
    repositories {
        maven("https://repo.spongepowered.org/repository/maven-public/")
    }
}

dependencyResolutionManagement.versionCatalogs.maybeCreate("catalog").apply {
    plugin("vanilla-gradle", "org.spongepowered.gradle.vanilla").version("0.2.1-SNAPSHOT")
}
