pluginManagement { repositories { maven("https://maven.minecraftforge.net/") { name = "Forge" } } }

val minecraft: String by settings.extra
val kotlin: String? by settings.extra

dependencyResolutionManagement {
    repositories {
        maven("https://thedarkcolour.github.io/KotlinForForge/") {
            content { includeGroup("thedarkcolour") }
        }
    }
}

dependencyResolutionManagement.versionCatalogs.maybeCreate("catalog").apply {
    plugin("forge-gradle", "net.minecraftforge.gradle").version("6.+")

    val forgeVersions = mapOf("1.20.1" to "47.3.5")
    // https://linkie.shedaniel.dev/dependencies?loader=forge
    library("minecraft-forge", "net.minecraftforge", "forge")
        .version(
            forgeVersions.getOrElse(minecraft) {
                error("Unknown minecraft version $minecraft to get forge version")
            })

    if (kotlin != null) {
        // https://modrinth.com/mod/kotlin-for-forge/versions
        val kotlinForgeVersions = mapOf("1.21" to "5.3.0", "1.20.1" to "4.11.0")
        library("kotlin-forge", "thedarkcolour", "kotlinforforge")
            .version(
                kotlinForgeVersions.getOrElse(minecraft) {
                    error("Unknown minecraft version $minecraft to get Kotlin For Forge version")
                })
    }
}
