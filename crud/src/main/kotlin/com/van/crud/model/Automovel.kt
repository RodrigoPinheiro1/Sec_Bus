package com.van.crud.model

import com.van.crud.dto.AutomovelDTO
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
data class Automovel(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    var modelo: String,

    var nomeCarro: String,

    var placa: String
) {

    fun toDTO(): AutomovelDTO {

        return AutomovelDTO(id, modelo, nomeCarro, placa)
    }
}