import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.6.4"
	id("io.spring.dependency-management") version "1.0.11.RELEASE"
	kotlin("jvm") version "1.6.10"
	kotlin("plugin.spring") version "1.6.10"
	kotlin("plugin.jpa") version "1.6.10"
}

group = "com.superchat"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_1_8

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-jpa:2.6.4")
	implementation("org.springframework.boot:spring-boot-starter-integration:2.6.4")
	implementation("org.springframework.boot:spring-boot-starter-web:2.6.4")
	implementation("org.springframework.boot:spring-boot-starter-websocket:2.6.4")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.13.1")
	implementation("org.jetbrains.kotlin:kotlin-reflect:1.6.10")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.6.10")
	implementation("org.springframework.integration:spring-integration-http:5.5.9")
	implementation("org.springframework.integration:spring-integration-jpa:5.5.9")
	implementation("org.springframework.integration:spring-integration-stomp:5.5.9")
	implementation("org.springframework.integration:spring-integration-websocket:5.5.9")
	implementation("org.springframework.cloud:spring-cloud-starter-openfeign:3.1.1")
	implementation("javax.validation:validation-api:2.0.1.Final")
	implementation("com.h2database:h2:2.1.210")
	runtimeOnly("org.postgresql:postgresql:42.3.3")
	testImplementation("org.springframework.boot:spring-boot-starter-test:2.6.4")
	testImplementation("org.springframework.integration:spring-integration-test:5.5.9")
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "1.8"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
