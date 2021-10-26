package org.hshekhar.config

import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.CorsRegistry

import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter

import org.springframework.web.servlet.config.annotation.EnableWebMvc




/**
 * @created 10/25/2021'T'6:04 PM
 * @author Himanshu Shekhar (609080540)
 **/

@Configuration
@EnableWebMvc
class WebConfig : WebMvcConfigurerAdapter() {
    override fun addCorsMappings(registry: CorsRegistry) {
        registry.addMapping("/**")
    }
}