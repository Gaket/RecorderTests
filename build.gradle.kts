import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.7.10"
    application
    id("org.jlleitschuh.gradle.ktlint") version "11.5.1"
}

ktlint {
    verbose.set(true)
    outputToConsole.set(true)
    coloredOutput.set(true)
}

group = "org.example"
version = "1.0-SNAPSHOT"



dependencies {
    testImplementation("com.codeborne:selenide-appium:6.17.0")
    testImplementation("org.junit.jupiter:junit-jupiter:5.10.0")
    testImplementation("commons-io:commons-io:2.13.0")
    testRuntimeOnly("org.slf4j:slf4j-simple:2.0.7")
    testImplementation("io.qameta.allure:allure-junit5:2.16.1")
    implementation("io.github.serpro69:kotlin-faker:1.14.0")

}

repositories {
    mavenCentral()
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

application {
    mainClass.set("MainKt")
}
