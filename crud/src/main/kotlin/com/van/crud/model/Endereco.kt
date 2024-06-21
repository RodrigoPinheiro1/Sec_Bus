package com.van.crud.model

import jakarta.persistence.Embeddable
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull

@Embeddable
data class Endereco(

    @field:NotBlank
    @field:NotNull
    var cep: String,
    @field:NotBlank
    @field:NotNull
    var cidade: String,

    @field:NotBlank
    @field:NotNull
    var numero: String,

    @field:NotBlank
    @field:NotNull
    var logradouro: String,


    var complemento: String,


    var bairro: String,


    var localidade: String
)