
val minecraft: String by settings.extra

dependencyResolutionManagement {
    repositories {
        maven("https://maven.isxander.dev/releases") {
            content {
                includeGroupAndSubgroups("dev.isxander")
            }
        }
    }
}

dependencyResolutionManagement.versionCatalogs.maybeCreate("catalog").apply {
    // https://modrinth.com/mod/yacl/versions
    val yaclVersions = mapOf(
        "1.21" to "3.5.0+$minecraft"
        "1.20.1" to "3.5.0+$minecraft"
    )

    val version = yaclVersions.getOrElse(minecraft) {
        error("Unknown minecraft version $minecraft to get yacl version")
    }
    library("yacl-fabric", "dev.isxander", "yet-another-config-lib").version("$version-fabric")

    library("yacl-neoforge", "dev.isxander", "yet-another-config-lib").version("$version-neoforge")
}
