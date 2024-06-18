val minecraft: String by settings.extra

dependencyResolutionManagement.versionCatalogs.maybeCreate("catalog").apply {
    // https://modrinth.com/mod/modmenu/versions
    val modmenuVersions = mapOf(
        "1.21" to "11.0.0-rc.4"
    )
    library(
        "modmenu",
        "com.terraformersmc",
        "modmenu"
    ).version(modmenuVersions.getOrElse(minecraft) {
        error("Unknown minecraft version $minecraft to get modmenu version")
    })
}
