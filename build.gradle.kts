import io.gitlab.arturbosch.detekt.Detekt
import org.jetbrains.kotlin.gradle.dsl.JvmDefaultMode
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.springframework.boot.gradle.tasks.bundling.BootBuildImage

plugins {
    kotlin("jvm") version "2.3.21"
    kotlin("plugin.spring") version "2.2.21"
    id("org.springframework.boot") version "4.0.6"
    id("io.spring.dependency-management") version "1.1.7"
    id("io.gitlab.arturbosch.detekt") version "1.23.8"
    id("com.google.protobuf") version "0.10.0"
}

group = "de.envite.sample.spring.clean.football"
version = "latest"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

repositories {
    mavenCentral()
}

extra["springGrpcVersion"] = "1.0.0"
extra["springModulithVersion"] = "2.0.6"

dependencies {
    implementation("tools.jackson.module:jackson-module-kotlin")
    implementation("net.logstash.logback:logstash-logback-encoder:9.0")
    implementation("io.grpc:grpc-services")
    implementation("org.springframework.grpc:spring-grpc-server-web-spring-boot-starter")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    implementation("org.springframework.boot:spring-boot-starter-data-jdbc")
    implementation("org.flywaydb:flyway-core")
    implementation("org.flywaydb:flyway-database-postgresql")
    runtimeOnly("org.postgresql:postgresql")

    // Spring Modulith dependencies
    implementation("org.springframework.modulith:spring-modulith-starter-core")
    runtimeOnly("org.springframework.modulith:spring-modulith-actuator")
    runtimeOnly("org.springframework.modulith:spring-modulith-observability")

    testImplementation("com.ninja-squad:springmockk:5.0.1")
    testImplementation("org.springframework.boot:spring-boot-starter-webmvc-test")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.springframework.boot:spring-boot-testcontainers")
    testImplementation("org.springframework.grpc:spring-grpc-test")
    testImplementation("org.springframework.modulith:spring-modulith-starter-test")
    testImplementation("org.testcontainers:junit-jupiter:1.21.4")
    testImplementation("org.testcontainers:postgresql:1.21.4")
    testImplementation("org.wiremock:wiremock-standalone:3.13.2")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")

    // Additional Detekt rules (Previously part of detekt)
    detektPlugins("io.gitlab.arturbosch.detekt:detekt-formatting:1.23.8")
}

// Usually Detekt brings along and needs its own Kotlin version to run.
// This block here ensures that all detekt dependencies still use this Kotlin version.
// Without the block, Detekt's Kotlin version would be overridden by the Spring Dependency Management,
// causing Detekt to throw a "wrong Kotlin version" exception at runtime
// when an incompatible Kotlin version is forced onto it.
configurations.matching { it.name.contains("detekt") }.all {
    resolutionStrategy.eachDependency {
        if (requested.group == "org.jetbrains.kotlin") {
            useVersion(io.gitlab.arturbosch.detekt.getSupportedKotlinVersion())
        }
    }
}

dependencyManagement {
    imports {
        mavenBom("org.springframework.grpc:spring-grpc-dependencies:${property("springGrpcVersion")}")
        mavenBom("org.springframework.modulith:spring-modulith-bom:${property("springModulithVersion")}")
    }
}

kotlin {
    compilerOptions {
        freeCompilerArgs.addAll("-Xjsr305=strict", "-Xannotation-default-target=param-property")
    }
}

protobuf {
    protoc {
        artifact = "com.google.protobuf:protoc:${dependencyManagement.importedProperties["protobuf-java.version"]}"
    }
    plugins {
        register("grpc") {
            artifact = "io.grpc:protoc-gen-grpc-java:${dependencyManagement.importedProperties["grpc.version"]}"
        }
    }
    generateProtoTasks {
        all().forEach { task ->
            task.plugins {
                register("grpc") {
                    option("jakarta_omit")
                    option("@generated=omit")
                }
            }
        }
    }
}

tasks {
    detekt {
        parallel = true
        config.setFrom(rootProject.files("detekt-config.yml").files)
        buildUponDefaultConfig = true
    }

    withType<Detekt> {
        // Target version of the generated JVM bytecode. It is used for type resolution.
        this.jvmTarget = "21"
    }

    withType<KotlinCompile> {
        compilerOptions {
            freeCompilerArgs =
                listOf("-Xjsr305=strict")
            jvmDefault.set(JvmDefaultMode.NO_COMPATIBILITY)
            jvmTarget = JvmTarget.JVM_21
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
        builder.set("dashaun/builder:base") // base instead of tiny otherwise health check does not work
        buildpacks.addAll("urn:cnb:builder:paketo-buildpacks/java", "docker.io/paketobuildpacks/health-checker:latest")
        environment.put("BP_HEALTH_CHECKER_ENABLED", "true")

        imageName.set("football-kotlin:spring")
    }
}
