package org.hshekhar.config

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import javax.servlet.http.HttpServletResponse
import org.hshekhar.tmf632.models.Error as APIError

/**
 * @created 10/22/2021'T'4:37 PM
 * @author Himanshu Shekhar (609080540)
 **/

enum class ErrorCode(val code: String) {
    ERR_NOT_IMPLEMENTED("ERR_01"),
    ERR_INTERNAL("ERR_02")
}

@ControllerAdvice
class APIExceptionHandlerAdvice {

    @ExceptionHandler(value = [NotImplementedError::class])
    fun onNotImplemented(ex: NotImplementedError, response: HttpServletResponse): ResponseEntity<APIError> {
        return ResponseEntity
            .status(HttpStatus.NOT_IMPLEMENTED)
            .body(
                APIError(
                    code = ErrorCode.ERR_NOT_IMPLEMENTED.code,
                    reason = "Service not implemented",
                    message = ex.message
                )
            )
    }

    @ExceptionHandler(value = [Error::class])
    fun onInternalError(ex: Error, response: HttpServletResponse): ResponseEntity<APIError> {
        return ResponseEntity
            .status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body(
                APIError(
                    code = ErrorCode.ERR_INTERNAL.code,
                    reason = "Internal server error",
                    message = ex.message
                )
            )
    }
}