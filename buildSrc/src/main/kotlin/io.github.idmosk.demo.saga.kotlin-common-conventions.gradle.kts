plugins {
    kotlin("jvm")
    id("org.jlleitschuh.gradle.ktlint")
}

group = "io.github.idmosk.demo"
version = "0.1.0"

repositories {
    mavenCentral()
    mavenLocal()
}

kotlin {
    jvmToolchain(17)
}

dependencies {
    constraints {
        implementation("org.apache.commons:commons-text:1.10.0")
    }

    testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")

    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.named<Test>("test") {
    useJUnitPlatform()
}
