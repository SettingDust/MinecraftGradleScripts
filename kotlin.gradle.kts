val kotlin = "2.0.0"
extra["kotlin"] = kotlin

dependencyResolutionManagement.versionCatalogs.maybeCreate("catalog").apply {
    version("kotlin", kotlin)
    plugin("kotlin-jvm", "org.jetbrains.kotlin.jvm").version(kotlin)
    plugin("kotlin-plugin-serialization", "org.jetbrains.kotlin.plugin.serialization").version(kotlin)


    library("kotlin-reflect", "org.jetbrains.kotlin", "kotlin-reflect").version(kotlin)

    val kotlinxSerialization = "1.7.0"
    library("kotlinx-serialization-core", "org.jetbrains.kotlinx", "kotlinx-serialization-core").version(kotlinxSerialization)
    library("kotlinx-serialization-json", "org.jetbrains.kotlinx", "kotlinx-serialization-json").version(kotlinxSerialization)

    library("kotlinx-coroutines", "org.jetbrains.kotlinx", "kotlinx-coroutines-core").version("1.9.0-RC")
}
