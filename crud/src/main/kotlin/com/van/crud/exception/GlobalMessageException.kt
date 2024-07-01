package com.van.crud.exception

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.http.converter.HttpMessageNotReadableException
import org.springframework.validation.FieldError
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice
import java.time.LocalDateTime
import java.time.LocalDateTime.now
import java.util.function.Function


@RestControllerAdvice
class GlobalMessageException {


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun validacaoCampos(exception: MethodArgumentNotValidException): ResponseEntity<MessageError> {


        val erros = exception.fieldErrors

        val errorValidations = erros.map { ErrorValidation(it) }

        val messageError = MessageError(
            timestamp = now(),
            status = HttpStatus.BAD_REQUEST.value(),
            error = "error fields",
            errors = errorValidations
        )


        return ResponseEntity.badRequest().body(messageError)
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ResponsavelNotFoundException::class)
    fun responsavelNaoExiste(): MessageError {

        return MessageError(
            timestamp = now(),
            status = HttpStatus.NOT_FOUND.value(),
            error = "Responsavel não existe",
            errors = listOf()
        )

    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(MotoristaNotFoundException::class)
    fun motoristaNaoExiste(): MessageError {

        return MessageError(
            timestamp = now(),
            status = HttpStatus.NOT_FOUND.value(),
            error = "Motorista não existe",
            errors = listOf()
        )

    }
}