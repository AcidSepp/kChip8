plugins {
    alias(libs.plugins.kotlin)
}

group = "de.haw.landshut"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

val mockitoAgent = configurations.create("mockitoAgent")

dependencies {
    testImplementation(libs.assertj)
    mockitoAgent(libs.mockito) { isTransitive = false }
    testImplementation(libs.mockito.kotlin)
}

tasks.test {
    jvmArgs!!.add("-javaagent:${mockitoAgent.asPath}")
}

testing.suites.named<JvmTestSuite>("test") {
    useJUnitJupiter(libs.versions.junit)
}

kotlin {
    jvmToolchain(21)
}

