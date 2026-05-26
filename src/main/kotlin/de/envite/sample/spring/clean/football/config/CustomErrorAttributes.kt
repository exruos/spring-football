package de.envite.sample.spring.clean.football.config

import org.springframework.boot.web.error.ErrorAttributeOptions
import org.springframework.boot.webmvc.error.DefaultErrorAttributes
import org.springframework.stereotype.Component
import org.springframework.web.context.request.WebRequest

@Component
class CustomErrorAttributes : DefaultErrorAttributes() {

    override fun getErrorAttributes(webRequest: WebRequest, options: ErrorAttributeOptions): Map<String, Any?> {
        val errorAttributes = super.getErrorAttributes(webRequest, options)

        errorAttributes.remove("timestamp")
        errorAttributes.remove("path")

        return errorAttributes
    }
}
