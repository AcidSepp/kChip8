plugins {
    alias(libs.plugins.kotlin)
}

group = "de.haw.landshut"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(libs.assertj)
    testImplementation(libs.mockito)
}

testing.suites.named<JvmTestSuite>("test") {
    useJUnitJupiter(libs.versions.junit)
}

kotlin {
    jvmToolchain(21)
}

