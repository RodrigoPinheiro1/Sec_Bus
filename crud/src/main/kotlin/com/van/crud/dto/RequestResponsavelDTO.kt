package com.van.crud.dto

import com.van.crud.model.Endereco
import com.van.crud.model.Responsavel
import jakarta.validation.Valid
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import org.hibernate.validator.constraints.br.CPF
import java.time.LocalDate

data class RequestResponsavelDTO(
    val id: Long? = null,

    @field:NotBlank
    var nome: String?,
    @field:NotBlank
    var email: String?,
    @field:NotBlank
    var telefone: String?,
    @field:NotBlank
    @field:CPF
    var cpf: String?,
    @field:NotNull
    var dataNascimento: LocalDate,

    var aluno: List<AlunoDTO?> = mutableListOf(),
    @field:Valid
    var endereco: Endereco,
) {


    fun toEntity(): Responsavel {
        return Responsavel(
            nome = this.nome!!,
            email = this.email!!,
            telefone = this.telefone!!,
            cpf = this.cpf!!,
            dataNascimento = this.dataNascimento,
            endereco = this.endereco,
            motorista = null
        )

    }


}





