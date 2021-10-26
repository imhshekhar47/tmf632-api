package org.hshekhar.util

/**
 * @created 10/22/2021'T'7:34 PM
 * @author Himanshu Shekhar (609080540)
 **/

object APIBaseUrlConfig {

    private fun nullWhenBlank(text: String?): String? {
        return if (null == text || text.isBlank()) null else text
    }

    private fun lookupBaseUrlFromEnvironment(code: Int): String? {
        return nullWhenBlank(System.getenv("TMF_API_${code}_BASE_PATH"))
    }

    private fun lookupBasUrlFromProperty(code: Int): String? {
        return nullWhenBlank(System.getProperty("tmf-api.${code}.base-path"))
    }

    fun lookupBaseUrl(code: Int): String {
        return lookupBaseUrlFromEnvironment(code)
            ?: lookupBasUrlFromProperty(code)
            ?: throw RuntimeException("Missing Base URL configuration for TMF${code}")
    }

}