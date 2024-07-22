package com.van.crud.model

import jakarta.persistence.Embeddable
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size

@Embeddable
data class Endereco(

    @field:NotBlank
    @field:NotNull
    @field:Size(max = 8, min = 8)
    var cep: String?,

    @field:NotBlank
    @field:NotNull
    var numero: String?,

    var logradouro: String?,

    var complemento: String?,


    var bairro: String?,


    var localidade: String?,

    )