allprojects {
    // https://github.com/gradle/gradle/issues/15754
    repositories {
        maven("https://thedarkcolour.github.io/KotlinForForge/") {
            content {
                includeGroup("thedarkcolour")
            }
        }
        maven("https://maven.parchmentmc.org") {
            content {
                includeGroupAndSubgroups("org.parchmentmc")
            }
        }
        maven("https://maven.terraformersmc.com/") {
            content {
                includeGroupAndSubgroups("com.terraformersmc")
            }
        }
        maven("https://repo.spongepowered.org/repository/maven-public/")
        maven("https://maven.neoforged.net/releases")
    }
}
