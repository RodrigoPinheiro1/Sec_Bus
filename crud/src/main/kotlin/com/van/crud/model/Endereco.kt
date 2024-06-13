package com.van.crud.model

import jakarta.persistence.Embeddable
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull

@Embeddable
data class Endereco(
    var cep: String? = null,

    @field:NotNull
    @field:NotBlank
    var cidade: String,

    @field:NotNull
    @field:NotBlank
    var numero: String,

    @field:NotNull
    @field:NotBlank
    var logradouro: String,

    @field:NotNull
    @field:NotBlank
    var complemento: String,

    @field:NotNull
    @field:NotBlank
    var bairro: String,

    @field:NotNull
    @field:NotBlank
    var localidade: String
)