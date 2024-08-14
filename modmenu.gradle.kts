val minecraft: String by settings.extra

dependencyResolutionManagement {
    repositories {
        maven("https://maven.terraformersmc.com/") {
            content { includeGroupAndSubgroups("com.terraformersmc") }
        }
    }
}

dependencyResolutionManagement.versionCatalogs.maybeCreate("catalog").apply {
    // https://modrinth.com/mod/modmenu/versions
    val modmenuVersions = mapOf("1.21" to "11.0.0-rc.4", "1.20.1" to "7.2.2")
    library("modmenu", "com.terraformersmc", "modmenu")
        .version(
            modmenuVersions.getOrElse(minecraft) {
                error("Unknown minecraft version $minecraft to get modmenu version")
            })

    for (version in modmenuVersions) {
        library("modmenu-${version.key}", "com.terraformersmc", "modmenu").versionRef(version.value)
    }
}
