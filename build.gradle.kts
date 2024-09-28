import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    groovy
    id("org.jetbrains.intellij") version "1.17.4"
    id("org.jetbrains.kotlin.js") version "1.3.41"
    java
    kotlin("jvm") version "1.3.41"
}

group = "kodai2"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    compile("org.codehaus.groovy:groovy-all:2.3.11")
    implementation(kotlin("stdlib-jdk8"))
    implementation(kotlin("stdlib-js"))
    testCompile("junit", "junit", "4.12")
}

// See https://github.com/JetBrains/gradle-intellij-plugin/
intellij {
    version = "2019.2.4"
}
configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
}
kotlin.target.browser { }
kotlin.target.nodejs { }
tasks.getByName<org.jetbrains.intellij.tasks.PatchPluginXmlTask>("patchPluginXml") {
    changeNotes("""
      Add change notes here.<br>
      <em>most HTML tags may be used</em>""")
}
tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}