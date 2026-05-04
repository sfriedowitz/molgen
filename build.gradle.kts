group = "me.sfriedowitz"
version = "0.1.0"

plugins {
    `java-library`
    id("com.diffplug.spotless") version "6.25.0"
}

repositories {
   mavenCentral()
}

dependencies {
    // API
    api(libs.cdk.core)
    api(libs.slf4j.api)
    // Runtime
    implementation(libs.cdk.silent)
    implementation(libs.cdk.smiles)
    // Test
    testImplementation(libs.junit)
    testRuntimeOnly(libs.junit.platform.launcher)
    testImplementation(libs.assertj.core)
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21))
    }
    withSourcesJar()
    withJavadocJar()
}

tasks.test {
    useJUnitPlatform()
}

spotless {
    java {
        googleJavaFormat()
        importOrder()
    }
}
