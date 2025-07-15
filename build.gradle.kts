plugins {
    id("java")
}

group = "com.tosuki.odyssei"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven("https://hub.spigotmc.org/nexus/content/repositories/snapshots")
}

dependencies {
    implementation("org.postgresql:postgresql:42.7.3")
    implementation("com.zaxxer:HikariCP:6.3.0")

    compileOnly("org.projectlombok:lombok:1.18.32")
    annotationProcessor("org.projectlombok:lombok:1.18.32")

    compileOnly("org.spigotmc:spigot-api:1.16.5-R0.1-SNAPSHOT")
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.test {
    useJUnitPlatform()
}