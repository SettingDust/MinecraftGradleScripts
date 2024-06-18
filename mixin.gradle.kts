dependencyResolutionManagement {
    repositories {
        maven("https://repo.spongepowered.org/repository/maven-public/")
    }
}

dependencyResolutionManagement.versionCatalogs.maybeCreate("catalog").apply {
    library("mixin", "org.spongepowered", "mixin").version("0.8.5")
    val mixinextras = "0.3.6"
    library("mixinextras-common", "io.github.llamalad7", "mixinextras-common").version(mixinextras)
    library("mixinextras-neoforge", "io.github.llamalad7", "mixinextras-neoforge").version(mixinextras)
    library("mixinextras-fabric", "io.github.llamalad7", "mixinextras-fabric").version(mixinextras)
}
