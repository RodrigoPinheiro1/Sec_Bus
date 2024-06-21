package com.van.crud.dto

import com.van.crud.model.Aluno
import com.van.crud.model.Endereco
import com.van.crud.model.Motorista
import com.van.crud.model.Responsavel
import jakarta.validation.Valid
import jakarta.validation.constraints.NotBlank
import java.time.LocalDate

data class RequestResponsavelDTO(
    val id: Long? = null,

    @field:NotBlank
    var nome: String,
    var email: String,
    var telefone: String,
    var cpf: String,
    var dataNascimento: LocalDate,
    var motorista: RequestMotoristaDTO?,
    var aluno: List<AlunoDTO?> = mutableListOf(),
    @Valid
    var endereco: Endereco,
) {


    fun toEntity(): Responsavel {
        return Responsavel(
            nome = this.nome,
            email = this.email,
            telefone = this.telefone,
            cpf = this.cpf,
            dataNascimento = this.dataNascimento,
            endereco = this.endereco,
            motorista = motorista?.toEntity()
        )

    }


}





