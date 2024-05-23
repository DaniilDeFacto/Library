plugins {
	java
	application
	checkstyle
	id("org.springframework.boot") version "3.3.0-SNAPSHOT"
	id("io.spring.dependency-management") version "1.1.4"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_20
}

application {
	mainClass = "com.example.Application"
}

repositories {
	mavenCentral()
	maven { url = uri("https://repo.spring.io/milestone") }
	maven { url = uri("https://repo.spring.io/snapshot") }
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter-validation")
	implementation("org.springframework.boot:spring-boot-devtools")

	implementation("org.postgresql:postgresql:42.7.3")
	implementation("org.hibernate:hibernate-core:7.0.0.Alpha2")
	implementation("com.zaxxer:HikariCP:5.1.0")

	implementation("log4j:log4j:1.2.17")
	compileOnly ("org.projectlombok:lombok:1.18.32")
	annotationProcessor ("org.projectlombok:lombok:1.18.32")

	testImplementation("org.slf4j:slf4j-log4j12:2.0.13")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.withType<Test> {
	useJUnitPlatform()
}
