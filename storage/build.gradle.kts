plugins {
    id("io.github.idmosk.demo.saga.kotlin-library-conventions")
}

dependencies {
    implementation("io.github.idmosk.saga:spi-storage:0.1.0")
    implementation("io.github.idmosk.saga:spi-storage-test:0.1.0")
    implementation(testFixtures("io.github.idmosk.saga:spi-storage-test:0.1.0"))
}
