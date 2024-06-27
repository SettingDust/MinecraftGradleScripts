dependencyResolutionManagement {
    repositories {
        maven("https://jitpack.io") {
            content {
                includeGroupAndSubgroups("com.github")
            }
        }
        maven("https://repo.spongepowered.org/repository/maven-public/")
    }
}

dependencyResolutionManagement.versionCatalogs.maybeCreate("catalog").apply {
    library("mixin", "org.spongepowered", "mixin").version("0.8.5")
    val mixinextras = "0.3.6"
    library("mixinextras-common", "io.github.llamalad7", "mixinextras-common").version(mixinextras)
    library("mixinextras-neoforge", "io.github.llamalad7", "mixinextras-neoforge").version(mixinextras)
    library("mixinextras-fabric", "io.github.llamalad7", "mixinextras-fabric").version(mixinextras)

    val mixinsquared = "0.2.0-beta.3"
    library("mixinsquared-common", "com.github.bawnorton.mixinsquared", "mixinsquared-common").version(mixinsquared)
    library("mixinsquared-fabric", "com.github.bawnorton.mixinsquared", "mixinsquared-fabric").version(mixinsquared)
    library("mixinsquared-neoforge", "com.github.bawnorton.mixinsquared", "mixinsquared-neoforge").version(mixinsquared)
    library("mixinsquared-forge", "com.github.bawnorton.mixinsquared", "mixinsquared-forge").version(mixinsquared)
}
