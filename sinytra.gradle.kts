val minecraft: String by settings.extra

dependencyResolutionManagement {
    repositories {
        maven("https://maven.su5ed.dev/releases") {
            content { includeGroupAndSubgroups("org.sinytra") }
        }
    }
}

dependencyResolutionManagement.versionCatalogs.maybeCreate("catalog").apply {
    // https://modrinth.com/mod/forgified-fabric-api/versions
    val ffapiVersions = mapOf("1.21.1" to "0.104.0+2.0.15+$minecraft", "1.20.1" to "0.92.2+1.11.8+$minecraft")

    val ffapiVersion =
        ffapiVersions.getOrElse(minecraft) {
            error("Unknown minecraft version $minecraft to get Forgified Fabric API version")
        }
    if (minecraft == "1.20.1") {
        library("forgified-fabric-api", "dev.su5ed.sinytra.fabric-api", "fabric-api").version(ffapiVersion)
    } else {
        library("forgified-fabric-api", "org.sinytra.forgified-fabric-api", "forgified-fabric-api").version(ffapiVersion)
    }

    for (version in ffapiVersions) {
        if (version.key == "1.20.1") {
            library("forgified-fabric-api-${version.key}", "org.sinytra.forgified-fabric-api", "forgified-fabric-api").version(version.value)
        } else {
            library("forgified-fabric-api-${version.key}", "org.sinytra.forgified-fabric-api", "forgified-fabric-api").version(version.value)
        }

    }
}
