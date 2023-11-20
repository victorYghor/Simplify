buildscript {
    repositories { mavenCentral() }

    dependencies {
        val kotlinVersion = "1.8.10"
        classpath("com.google.gms:google-services:4.4.0")
        classpath(kotlin("gradle-plugin", version = kotlinVersion))
        classpath(kotlin("serialization", version = kotlinVersion))
    }
}
// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.1.0" apply false

    id("org.jetbrains.kotlin.android") version "1.8.10" apply false
    // Add the dependency for the Google services Gradle plugin
    id("com.google.gms.google-services") version "4.3.15" apply false
    // Serialization plugin
}