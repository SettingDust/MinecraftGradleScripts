pluginManagement {
    repositories {
        maven("https://maven.fabricmc.net/")
        maven("https://maven2.bai.lol")
    }
}

val minecraft: String by settings.extra
val kotlin: String? by settings.extra

// https://linkie.shedaniel.dev/dependencies?loader=fabric
dependencyResolutionManagement.versionCatalogs.maybeCreate("catalog").apply {
    plugin("explosion", "lol.bai.explosion").version("0.2.0")

    version("minecraft", minecraft)
    library("minecraft-fabric", "com.mojang", "minecraft").version(minecraft)

    plugin("fabric-loom", "fabric-loom").version("1.6.+")

    val yarnMappingVersions = mapOf(
        "1.21" to "2"
    )
    library("yarn", "net.fabricmc", "yarn").version(
        "$minecraft+build.${
            yarnMappingVersions.getOrElse(minecraft) {
                println("Unknown minecraft version $minecraft to get yarn mapping version. Fallback to 1")
                "1"
            }
        }"
    )

    library("fabric-loader", "net.fabricmc", "fabric-loader").version("0.15.11")

    val fabricApiVersions = mapOf(
        "1.21" to "0.100.1"
    )
    library("fabric-api", "net.fabricmc.fabric-api", "fabric-api").version("${
        fabricApiVersions.getOrElse(minecraft) {
            error("Unknown minecraft version $minecraft to get fabric api version")
        }
    }+$minecraft")

    if (kotlin != null) {
        // https://modrinth.com/mod/fabric-language-kotlin/versions
        val fabricKotlinVersions = mapOf(
            "2.0.0" to "1.11.0"
        )
        library(
            "fabric-kotlin",
            "net.fabricmc",
            "fabric-language-kotlin",
        )
            .version(
                "${
                    fabricKotlinVersions.getOrElse(kotlin!!) {
                        error("Unknown kotlin version $kotlin to get fabric kotlin api version")
                    }
                }+kotlin.$kotlin"
            )
    }

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
