pluginManagement {
    repositories {
        maven("https://maven.neoforged.net/releases") { name = "NeoForge" }
    }
}

val minecraft: String by settings.extra
val kotlin: String? by settings.extra

dependencyResolutionManagement {
    repositories {
        maven("https://thedarkcolour.github.io/KotlinForForge/") {
            content {
                includeGroup("thedarkcolour")
            }
        }
        maven("https://maven.neoforged.net/releases")
    }
}

dependencyResolutionManagement.versionCatalogs.maybeCreate("catalog").apply {
    plugin("neoforge-gradle", "net.neoforged.gradle.userdev").version("7.+")
    plugin("neoforge-gradle-vanilla", "net.neoforged.gradle.vanilla").version("7.+")
    plugin("neoforge-gradle-mixin", "net.neoforged.gradle.mixin").version("7.+")

    plugin("neoforge-moddev", "net.neoforged.moddev").version("1.+")

    val neoforgeVersions = mapOf(
        "1.21" to "21.0.167",
        "1.21.1" to "21.1.51"
    )
    // https://linkie.shedaniel.dev/dependencies?loader=neoforge
    library("neoforge", "net.neoforged", "neoforge").version(neoforgeVersions.getOrElse(minecraft) {
        error("Unknown minecraft version $minecraft to get neoforge version")
    })

    if (kotlin != null) {
        // https://modrinth.com/mod/kotlin-for-forge/versions
        val kotlinForgeVersions = mapOf(
            "1.21" to "5.3.0"
        )
        library("kotlin-neoforge", "thedarkcolour", "kotlinforforge-neoforge").version(
            kotlinForgeVersions.getOrElse(
                minecraft
            ) { error("Unknown minecraft version $minecraft to get Kotlin For Forge version") })
    }
}
