pluginManagement { repositories { maven("https://maven.minecraftforge.net/") { name = "Forge" } } }

val minecraft: String by settings.extra
val kotlin: String? by settings.extra

dependencyResolutionManagement {
    repositories {
        maven("https://thedarkcolour.github.io/KotlinForForge/") {
            content { includeGroup("thedarkcolour") }
        }
        maven("https://maven.cleanroommc.com") {
            content { includeGroup("io.github.chaosunity.forgelin") }
        }
    }
}

dependencyResolutionManagement.versionCatalogs.maybeCreate("catalog").apply {
    plugin("forge-gradle", "net.minecraftforge.gradle").version("6.+")

    val forgeVersions = mapOf("1.20.1" to "47.3.5")
    // https://linkie.shedaniel.dev/dependencies?loader=forge
    library("minecraft-forge", "net.minecraftforge", "forge")
        .version(
            "$minecraft-${forgeVersions.getOrElse(minecraft) {
                error("Unknown minecraft version $minecraft to get forge version")
            }}")

    if (kotlin != null) {
        // https://modrinth.com/mod/kotlin-for-forge/versions
        // https://modrinth.com/mod/forgelin-continuous/versions
        val kotlinForgeVersions = mapOf("1.21" to "5.3.0", "1.20.1" to "4.11.0", "1.12.2" to "2.0.0.0")
        if (minecraft == "1.12.2") {
            library("kotlin-forge", "io.github.chaosunity.forgelin", "Forgelin-Continuous")
                .version(
                    kotlinForgeVersions.getOrElse(minecraft) {
                        error("Unknown minecraft version $minecraft to get Kotlin For Forge version")
                    })
        } else {
            library("kotlin-forge", "thedarkcolour", "kotlinforforge")
                .version(
                    kotlinForgeVersions.getOrElse(minecraft) {
                        error("Unknown minecraft version $minecraft to get Kotlin For Forge version")
                    })
        }
    }
}
