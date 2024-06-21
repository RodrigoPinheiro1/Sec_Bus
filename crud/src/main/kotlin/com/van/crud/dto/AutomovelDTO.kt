package com.van.crud.dto

import com.van.crud.model.Automovel

data class AutomovelDTO(
    val id: Long? = null,

    var modelo: String,

    var nomeCarro: String,

    var placa: String

) {

    fun toEntity(): Automovel {

        return Automovel(id, modelo, nomeCarro, placa)
    }
}
