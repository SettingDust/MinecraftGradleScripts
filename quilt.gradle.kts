pluginManagement {
    repositories {
        maven("https://maven.quiltmc.org/repository/release")
    }
}

// https://quiltmc.org/en/usage/latest-versions/
dependencyResolutionManagement.versionCatalogs.maybeCreate("catalog").apply {
    library("quilt-loader", "org.quiltmc", "quilt-loader").version("0.26.0")
    plugin("quilt-loom", "org.quiltmc.loom").version("1.6.+")
}
