dependencyResolutionManagement {
    repositories {
        maven("https://maven.architectury.dev/") { content { includeGroup("dev.architectury") } }
    }
}

val minecraft: String by settings.extra

dependencyResolutionManagement.versionCatalogs.maybeCreate("catalog").apply {
    val architecturyVersions = mapOf("1.21" to "13.0.8", "1.20.1" to "9.2.14")
    val architecturyVersion = architecturyVersions[minecraft] ?: error("Unsupported minecraft version $minecraft")
    library("architectury", "dev.architectury", "architectury").version(architecturyVersion)
    library("architectury-fabric", "dev.architectury", "architectury-fabric").version(architecturyVersion)
    library("architectury-forge", "dev.architectury", "architectury-forge").version(architecturyVersion)
    library("architectury-neoforge", "dev.architectury", "architectury-neoforge").version(architecturyVersion)
}
