import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.springframework.boot.gradle.tasks.bundling.BootBuildImage

plugins {
    kotlin("jvm") version "2.4.0"
    kotlin("plugin.spring") version "2.4.0"
    id("org.springframework.boot") version "4.1.0"
    id("io.spring.dependency-management") version "1.1.7"
    id("dev.detekt") version "2.0.0-alpha.5"
    id("org.graalvm.buildtools.native") version "1.1.5"
}

group = "de.envite.sample.spring.clean.football"
version = "latest"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(25)
    }
}

repositories {
    mavenCentral()
}

extra["springModulithVersion"] = "2.0.7"

dependencies {
    implementation("tools.jackson.module:jackson-module-kotlin")
    implementation("net.logstash.logback:logstash-logback-encoder:9.0")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    implementation("org.springframework.boot:spring-boot-starter-data-jdbc")
    implementation("org.flywaydb:flyway-core")
    implementation("org.flywaydb:flyway-database-postgresql")
    runtimeOnly("org.postgresql:postgresql")

    // Spring Modulith dependencies
    implementation("org.springframework.modulith:spring-modulith-starter-core")
    runtimeOnly("org.springframework.modulith:spring-modulith-actuator")
    if (!project.hasProperty("nativeBuild")) {
        runtimeOnly("org.springframework.modulith:spring-modulith-observability")
    }

    testImplementation("com.ninja-squad:springmockk:5.0.1")
    testImplementation("org.springframework.boot:spring-boot-starter-webmvc-test")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.springframework.boot:spring-boot-testcontainers")
    testImplementation("org.springframework.modulith:spring-modulith-starter-test")
    testImplementation("org.testcontainers:junit-jupiter:1.21.4")
    testImplementation("org.testcontainers:postgresql:1.21.4")
    testImplementation("org.wiremock:wiremock-standalone:3.13.2")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

dependencyManagement {
    imports {
        mavenBom("org.springframework.modulith:spring-modulith-bom:${property("springModulithVersion")}")
    }
}

kotlin {
    compilerOptions {
        freeCompilerArgs.addAll("-Xjsr305=strict")
    }
}

graalvmNative {
    binaries {
        named("main") {
            buildArgs.add("--initialize-at-run-time=org.springframework.modulith.observability")
        }
    }
}

tasks {
    withType<KotlinCompile> {
        compilerOptions {
            freeCompilerArgs =
                listOf("-Xjsr305=strict")
            jvmTarget = JvmTarget.JVM_25
            javaParameters = true
            allWarningsAsErrors = true
        }
    }

    withType<Test> {
        useJUnitPlatform()
        maxParallelForks = 1
        maxHeapSize = "1g"
    }

    withType<Test>().configureEach {
        jvmArgs("--add-opens", "java.base/java.io=ALL-UNNAMED")
        jvmArgs("--add-opens", "java.base/java.time=ALL-UNNAMED")
    }

    withType<BootBuildImage> {
        imagePlatform = "linux/amd64" // GMT requires AMD64 architecture
        builder.set("paketobuildpacks/builder-jammy-base") // base instead of tiny otherwise health check does not work
        environment.put("BP_HEALTH_CHECKER_ENABLED", "true")
        environment.put("BP_NATIVE_IMAGE", "true")

        imageName.set("football-kotlin:native")
    }
}
