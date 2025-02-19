allprojects {
    // https://github.com/gradle/gradle/issues/15754
    repositories {
        maven("https://thedarkcolour.github.io/KotlinForForge/") {
            content { includeGroup("thedarkcolour") }
        }
        maven("https://maven.parchmentmc.org") {
            content { includeGroupAndSubgroups("org.parchmentmc") }
        }
        maven("https://maven.terraformersmc.com/") {
            content { includeGroupAndSubgroups("com.terraformersmc") }
        }
        maven("https://maven.isxander.dev/releases") {
            content { includeGroupAndSubgroups("dev.isxander") }
        }
        maven("https://api.modrinth.com/maven") { content { includeGroup("maven.modrinth") } }
        maven("https://jitpack.io") { content { includeGroupAndSubgroups("com.github") } }
        maven("https://maven.cleanroommc.com") {
            content {
                includeGroup("io.github.chaosunity.forgelin")
                includeGroup("zone.rong")
            }
        }
        maven("https://maven.bawnorton.com/releases") {
            content {
                includeGroup("com.github.bawnorton.mixinsquared")
            }
        }
        maven("https://maven.architectury.dev/") { content { includeGroup("dev.architectury") } }
        maven("https://maven.su5ed.dev/releases") {
            content {
                includeGroupAndSubgroups("dev.su5ed")
                includeGroupAndSubgroups("org.sinytra")
            }
        }
        maven("https://repo.spongepowered.org/repository/maven-public/")
        maven("https://maven.neoforged.net/releases")
        mavenCentral()
    }
}
