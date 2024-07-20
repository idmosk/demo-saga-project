plugins {
    id("io.github.idmosk.demo.saga.kotlin-application-conventions")
    id("org.springframework.boot") version "3.1.2"
//    id("org.springframework.boot") version "2.7.18"
    id("io.spring.dependency-management") version "1.1.2"
//    kotlin("jvm") version "2.0.0" // The version of Kotlin to use
//    kotlin("plugin.spring") version "2.0.0" // The Kotlin Spring plugin
//    kotlin("plugin.spring") version "1.9.24" // The Kotlin Spring plugin
}

dependencies {
    implementation(project(":storage"))
    implementation(project(":queue"))

    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.springframework.boot:spring-boot-starter-webflux")
    implementation("org.jetbrains.kotlin:kotlin-reflect") // Kotlin reflection library, required for working with Spring
    implementation("io.github.idmosk.saga.spring-boot-3:api-spring-boot-starter:0.1.0")
//    implementation("io.github.idmosk.saga.spring-boot-2:api-spring-boot-starter:0.1.0")
    implementation(testFixtures("io.github.idmosk.saga:api:0.1.0"))
    implementation(testFixtures("io.github.idmosk.saga:spi-storage-test:0.1.0"))
    implementation(testFixtures("io.github.idmosk.saga:spi-queue-test:0.1.0"))
    implementation("io.projectreactor.kotlin:reactor-kotlin-extensions")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor")

    testImplementation("io.projectreactor:reactor-test")
    testImplementation("org.springframework.boot:spring-boot-starter-test")

    implementation("org.apache.commons:commons-text")
}

application {
    mainClass.set("io.github.idmosk.demo.saga.AppKt")
}
