plugins {
    id("io.github.idmosk.demo.saga.kotlin-library-conventions")
}

dependencies {
    implementation("io.github.idmosk.saga:spi-queue:0.1.0")
    implementation("io.github.idmosk.saga:spi-queue-test:0.1.0")
    implementation(testFixtures("io.github.idmosk.saga:spi-queue-test:0.1.0"))
}
