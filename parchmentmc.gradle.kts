pluginManagement {
    repositories {
        maven("https://maven.parchmentmc.org") {
            content {
                includeGroupAndSubgroups("org.parchmentmc")
            }
        }
    }
}

dependencyResolutionManagement {
    repositories {
        maven("https://maven.parchmentmc.org") {
            content {
                includeGroupAndSubgroups("org.parchmentmc")
            }
        }
    }
}

dependencyResolutionManagement.versionCatalogs.maybeCreate("catalog").apply {
    val minecraftParchmentmc = "1.20.6"
    version("minecraft-parchmentmc", minecraftParchmentmc)
    val parchmentmc = "2024.06.16"
    version("parchmentmc", parchmentmc)

    library("parchmentmc-loom", "org.parchmentmc.data", "parchment-$minecraftParchmentmc").version(parchmentmc)
}
