plugins {
    java
    kotlin("jvm") version "1.4.21"
    kotlin("kapt") version "1.4.21"
    kotlin("plugin.jpa") version "1.4.21"

    kotlin("plugin.spring") version "1.4.21"
    id("org.springframework.boot") version "2.4.1"
    id("io.spring.dependency-management") version "1.0.10.RELEASE"

    id("de.undercouch.download") version "4.1.1"
    id("org.openapi.generator") version "5.0.0"
}

group = "org.hshekhar"
version = "0.0.1-SNAPSHOT"

val artifactName="tmf632-api"

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
}

sourceSets.getByName("main") {
    java.srcDirs(
        "${project.buildDir}/generated/src/main/kotlin"
    )
}


repositories {
    mavenCentral()
}

dependencies {
    kapt("org.mapstruct:mapstruct-processor:1.4.2.Final")

    implementation(kotlin("reflect"))
    implementation(kotlin("stdlib-jdk8"))

    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-data-jdbc")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")


    implementation("io.swagger:swagger-annotations:1.6.2")
    implementation("org.springdoc:springdoc-openapi-ui:1.5.2")
    implementation("org.springdoc:springdoc-openapi-kotlin:1.5.2")


    implementation("javax.validation:validation-api:2.0.0.Final")
    implementation("org.hibernate:hibernate-core:5.4.1.Final")
    implementation("org.mapstruct:mapstruct:1.4.2.Final")

    runtimeOnly("mysql:mysql-connector-java")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.4.2")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.4.2")
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "1.8"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

tasks.getByName<org.springframework.boot.gradle.tasks.bundling.BootJar>("bootJar") {
    manifest {
        attributes(
            "Main-Class" to "org.springframework.boot.loader.JarLauncher",
            "Start-Class" to "${project.group}.ApplicationKt"
        )
    }
    launchScript {
        properties(mapOf(
            "mode" to "service",
            "pidFolder" to "pid",
            "logFolder" to "logs",
            "logFilename" to "${project.name}.log"
        ))
    }
}

tasks.register<de.undercouch.gradle.tasks.download.Download>("download-spec") {
    src("https://tmf-open-api-table-documents.s3.eu-west-1.amazonaws.com/OpenApiTable/4.0.0/swagger/TMF632-Party-v4.0.0.swagger.json")
    dest("${project.buildDir}")
    overwrite(true)
}

tasks.register<org.openapitools.generator.gradle.plugin.tasks.GenerateTask>("generate") {
    generatorName.set("kotlin-spring")
    inputSpec.set("${project.buildDir}/TMF632-Party-v4.0.0.swagger.json")
    outputDir.set("${project.buildDir}/generated")
    packageName.set("${project.group}.tmf632")
    invokerPackage.set("${project.group}.tmf632")

    configOptions.set(mapOf(
        "dateLibrary" to "java8",
        "swaggerAnnotations" to "true",
        "serviceInterface" to "true",
        "serializationLibrary" to "jackson",
        "modelMutable" to "true",
        "enumPropertyNaming" to "original",
        "collectionType" to "list"))
    globalProperties.set(mapOf(
        "modelDocs" to "false"))
    generateApiTests.set(false)
    generateApiDocumentation.set(true)
    enablePostProcessFile.set(false)
    logToStderr.set(true)

    doLast {
        val generatedApiDir = "${project.buildDir}/generated/src/main/kotlin/${project.group.toString().replace(".","/")}/tmf632"
        delete(
            file("$generatedApiDir/Application.kt")
        )
    }
}

tasks.getByName("generate").dependsOn("download-spec")
tasks.getByName("compileKotlin").dependsOn("generate")


tasks.register<Copy>("generateDockerFiles") {
    doFirst {
        File("${project.buildDir}/libs", "Dockerfile").writeText(text = """                         
            FROM imhshekhar47/jre-skywalkng-base:v0.0.1               
            ENV APP_VERSION=${project.version}                                                      
            COPY $artifactName-${project.version}.jar /$artifactName.jar    
            EXPOSE 8080
            ENTRYPOINT ["sh", "-c", "java ${'$'}JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /$artifactName.jar"]
        """.trimIndent())
        File("${project.buildDir}/libs", "build.properties").writeText(text = """                                                             
            name=${project.name}                                                                    
            tag=${project.version}                                                                  
        """.trimIndent())
    }
    from( "${project.projectDir}/build/libs/")
    into("${project.buildDir}/docker/")
}

tasks.register<Zip>("packageZip") {
    dependsOn(tasks.named("generateDockerFiles"))
    archiveFileName.set("$artifactName.zip")
    destinationDirectory.set(layout.buildDirectory.dir("${project.buildDir}"))
    from(layout.buildDirectory.dir("${project.buildDir}/docker"))
}

tasks.getByName("build").finalizedBy("packageZip")