package org.hshekhar

import io.swagger.v3.oas.annotations.OpenAPIDefinition
import io.swagger.v3.oas.annotations.info.Contact
import io.swagger.v3.oas.annotations.info.Info
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication


/**
 * @created 10/22/2021'T'3:25 PM
 * @author Himanshu Shekhar
 **/

@OpenAPIDefinition(
    info = Info(
        title = "TMF632: Party Management APIs",
        description = """Implementation of party management APIs""",
        version = "v0.0.1-SNAPSHOT",
        contact = Contact(
            name = "Himanshu Shekhar",
        )
    )
)
@EntityScan(basePackages = ["org.hshekhar.entity"])
@SpringBootApplication
class Application

fun main() {
    runApplication<Application>()
}