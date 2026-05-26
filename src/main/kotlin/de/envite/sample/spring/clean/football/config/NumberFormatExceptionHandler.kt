package de.envite.sample.spring.clean.football.config

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class NumberFormatExceptionHandler {

    @ExceptionHandler(NumberFormatException::class)
    fun handleTypeMismatch(): ResponseEntity<Map<String, Any>> {
        val body = mapOf(
            "status" to HttpStatus.BAD_REQUEST.value(),
            "error" to "Invalid id"
        )

        return ResponseEntity(body, HttpStatus.BAD_REQUEST)
    }
}
