package com.hoona.zaid.student.framework.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import java.lang.Exception

@RestControllerAdvice
class ExceptionHandler {

    @ExceptionHandler(Exception::class)
    fun handleException(exception: Exception): SimpleErrorMessage {
        return SimpleErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR, exception.message)
    }
}
