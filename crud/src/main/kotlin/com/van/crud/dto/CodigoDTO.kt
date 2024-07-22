package com.van.crud.dto

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull

data class CodigoDTO (

    @field:NotBlank
    @field:NotNull
    var codigo: String?,
)
