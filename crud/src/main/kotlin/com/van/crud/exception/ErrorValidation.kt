package com.van.crud.exception

import org.springframework.validation.FieldError

data class ErrorValidation(
    var  campo:String,
    var  mensagem: String?){



    constructor(error: FieldError) :this (
        campo = error.field,
        mensagem = error.defaultMessage
    )
}


