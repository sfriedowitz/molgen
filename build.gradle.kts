plugins {
    java
}

repositories {
    mavenCentral()
}

dependencies {
    // Runtime
    implementation("com.google.guava:guava:33.0.0-jre")

    // Testing
    testImplementation("org.junit.jupiter:junit-jupiter:5.10.2")
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21))
    }
}

tasks.test {
    useJUnitPlatform()
}