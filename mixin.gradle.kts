pluginManagement {
    repositories { maven("https://repo.spongepowered.org/repository/maven-public/") }
}

dependencyResolutionManagement {
    repositories {
        maven("https://maven.bawnorton.com") {
            content { includeGroupAndSubgroups("com.bawnorton.mixinsquared") }
        }
        maven("https://maven.cleanroommc.com") { content { includeGroup("zone.rong") } }
        maven("https://repo.spongepowered.org/repository/maven-public/")
    }
}

dependencyResolutionManagement.versionCatalogs.maybeCreate("catalog").apply {
    plugin("mixin", "org.spongepowered.mixin").version("0.7-SNAPSHOT")

    library("mixin", "org.spongepowered", "mixin").version("0.8.7")
    val mixinextras = "0.5.0-beta.1"
    library("mixinextras-common", "io.github.llamalad7", "mixinextras-common").version(mixinextras)
    library("mixinextras-neoforge", "io.github.llamalad7", "mixinextras-neoforge")
        .version(mixinextras)
    library("mixinextras-fabric", "io.github.llamalad7", "mixinextras-fabric").version(mixinextras)

    val mixinsquared = "0.2.0-beta.6"
    library("mixinsquared-common", "com.bawnorton.mixinsquared", "mixinsquared-common")
        .version(mixinsquared)
    library("mixinsquared-fabric", "com.bawnorton.mixinsquared", "mixinsquared-fabric")
        .version(mixinsquared)
    library("mixinsquared-neoforge", "com.bawnorton.mixinsquared", "mixinsquared-neoforge")
        .version(mixinsquared)
    library("mixinsquared-forge", "com.bawnorton.mixinsquared", "mixinsquared-forge")
        .version(mixinsquared)

    library("mixinbooter", "zone.rong", "mixinbooter").version("9.1")
}
