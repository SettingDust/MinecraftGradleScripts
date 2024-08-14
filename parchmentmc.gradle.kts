pluginManagement {
    repositories {
        maven("https://maven.parchmentmc.org") {
            content { includeGroupAndSubgroups("org.parchmentmc") }
        }
    }
}

val minecraft: String by settings.extra

dependencyResolutionManagement {
    repositories {
        maven("https://maven.parchmentmc.org") {
            content { includeGroupAndSubgroups("org.parchmentmc") }
        }
    }
}

dependencyResolutionManagement.versionCatalogs.maybeCreate("catalog").apply {
    val parchmentmcVersions = mapOf("1.21" to "2024.07.07", "1.20.1" to "2023.09.03")
    val parchmentmcVersion =
        parchmentmcVersions[minecraft]?.let { minecraft to it }
            ?: parchmentmcVersions.entries.first().toPair()

    version("parchmentmc", parchmentmcVersion.second)

    library("parchmentmc-loom", "org.parchmentmc.data", "parchment-${parchmentmcVersion.first}")
        .version(parchmentmcVersion.second)
    plugin("librarian-forgegradle", "org.parchmentmc.librarian.forgegradle").version("1.+")

    for (version in parchmentmcVersions) {
        version("parchmentmc-${version.key}", version.value)

        library("parchmentmc-loom-${version.key}", "org.parchmentmc.data", "parchment-${version.key}")
            .version(version.value)
    }
}
