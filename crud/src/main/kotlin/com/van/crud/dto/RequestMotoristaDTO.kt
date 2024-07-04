package com.van.crud.dto

import com.van.crud.model.Endereco
import com.van.crud.model.Motorista
import jakarta.validation.Valid
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import mu.KotlinLogging
import java.util.*

private val logger = KotlinLogging.logger {}

data class RequestMotoristaDTO(

    var id: Long? = null,
    @field:NotBlank
    @field:NotNull
    var nome: String?,
    @field:NotBlank
    @field:NotNull
    var cpf: String?,
    @field:NotBlank
    @field:NotNull
    var cnh: String?,
    @field:NotBlank
    @field:NotNull
    var telefone: String?,

    var dataDeNascimento: Date,
    @field:Valid
    var automovel: AutomovelDTO,
    @field:Valid
    var endereco: Endereco,
) {
    fun toEntity(): Motorista {

        logger.info { "convertendo DTO para Entidade" }

        return Motorista(
            id = this.id,
            nome = this.nome ?: "",
            cpf = cpf ?: "",
            telefone = telefone ?: "",
            dataDeNascimento = dataDeNascimento,
            cnh = cnh ?: "",
            endereco = endereco,
            codigoSeguranca = null,
            automovel = automovel.toEntity()
        )
    }

}
