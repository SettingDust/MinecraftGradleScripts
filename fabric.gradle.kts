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
    library("minecraft-fabric", "com.mojang", "minecraft").version(minecraft)

    plugin("fabric-loom", "fabric-loom").version("1.7.+")

    val yarnMappingVersions = mapOf("1.21" to "9", "1.20.1" to "10")
    library("mapping-yarn", "net.fabricmc", "yarn")
        .version(
            "$minecraft+build.${
                yarnMappingVersions.getOrElse(minecraft) {
                    println("Unknown minecraft version $minecraft to get yarn mapping version. Fallback to 1")
                    "1"
                }
            }")

    for (version in yarnMappingVersions) {
        library("mapping-yarn-${version.key}", "net.fabricmc", "yarn")
            .version("${version.key}+build.${version.value}")
    }

    library("fabric-loader", "net.fabricmc", "fabric-loader").version("0.16.5")

    val fabricApiVersions = mapOf("1.21" to "0.102.0", "1.20.1" to "0.92.2")
    library("fabric-api", "net.fabricmc.fabric-api", "fabric-api")
        .version(
            "${
                fabricApiVersions.getOrElse(minecraft) {
                    error("Unknown minecraft version $minecraft to get fabric api version")
                }
            }+$minecraft")

    for (version in fabricApiVersions) {
        library("fabric-api-${version.key}", "net.fabricmc.fabric-api", "fabric-api")
            .version("${version.value}+${version.key}")
    }

    if (kotlin != null) {
        // https://modrinth.com/mod/fabric-language-kotlin/versions
        val fabricKotlinVersions = mapOf("2.0.20" to "1.12.1")
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
                }+kotlin.$kotlin")
    }
}
