group = "me.sfriedowitz"
version = "0.1.0"

plugins {
    `java-library`
}

repositories {
   mavenCentral()
}

dependencies {
    // API
    api("org.openscience.cdk:cdk-core:2.12")
    // Testing
    testImplementation("org.junit.jupiter:junit-jupiter:5.10.2")
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