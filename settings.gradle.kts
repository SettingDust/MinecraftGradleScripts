rootProject.name = "MinecraftGradleScripts"

val minecraft: String by settings.extra
val kotlin: String? by settings.extra

dependencyResolutionManagement.versionCatalogs.maybeCreate("catalog").apply {
    if (kotlin != null) {
        version("kotlin", kotlin!!)
        plugin("kotlin-jvm", "org.jetbrains.kotlin.jvm").version(kotlin!!)
        plugin("kotlin-plugin-serialization", "org.jetbrains.kotlin.plugin.serialization").version(kotlin!!)
    }
}
