/*
 * This file was generated by the Gradle 'init' task.
 */
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "2.4.5"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    kotlin("jvm") version "1.4.32"
    kotlin("plugin.spring") version "1.4.32"
    kotlin("plugin.serialization") version "1.4.32"
    application
}

repositories {
    mavenCentral()

}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-data-mongodb")
    implementation("org.springframework.boot:spring-boot-starter-security")
    implementation("org.springframework.boot:spring-boot-starter-aop")
    implementation("org.springframework.boot:spring-boot-starter-mail")
    implementation("org.springframework.data:spring-data-jpa")
    implementation("org.springframework.boot:spring-boot-configuration-processor")

    implementation("org.passay:passay:1.6.0")
    implementation("javax.xml.bind:jaxb-api:2.3.1")

    implementation("io.springfox:springfox-swagger-ui:2.9.2")
    implementation("io.springfox:springfox-swagger2:2.9.2")

    implementation("io.jsonwebtoken:jjwt-api:0.11.2")
    runtimeOnly("io.jsonwebtoken:jjwt-impl:0.11.2")
    runtimeOnly("io.jsonwebtoken:jjwt-jackson:0.11.2")

    implementation("org.apache.commons:commons-collections4:4.4")
    implementation("javax.validation:validation-api:2.0.1.Final")
    implementation("org.apache.commons:commons-lang3:3.12.0")
    implementation("com.google.guava:guava:30.1-jre")

    implementation("com.sun.xml.bind:jaxb-core:3.0.1")
    implementation("com.sun.xml.bind:jaxb-impl:3.0.1")

    implementation("org.springframework.security.oauth.boot:spring-security-oauth2-autoconfigure:2.4.5")

    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.4.32")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-runtime:1.0-M1-1.4.0-rc")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-core:1.1.0")
    implementation("org.jetbrains.kotlin:kotlin-serialization:1.4.32")
    implementation("org.jetbrains.kotlin:kotlin-maven-serialization:1.4.32")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.1.0")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.hamcrest:hamcrest-library:2.2")
    testImplementation("junit:junit:4.12")
    testImplementation("org.jetbrains.kotlin:kotlin-test:1.4.32")
}

group = "ru.kemsu.openenv"
version = "0.0.1-SNAPSHOT"
description = "OpenenvBackend"

java.sourceCompatibility = JavaVersion.VERSION_11

application {
    mainClassName = "ru.kemsu.openenv.Application"
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "11"
    }
}