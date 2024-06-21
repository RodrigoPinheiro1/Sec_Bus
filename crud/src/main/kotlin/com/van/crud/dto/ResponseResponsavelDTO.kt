package com.van.crud.dto

import com.van.crud.model.Endereco
import com.van.crud.model.Motorista
import java.time.LocalDate


data class ResponseResponsavelDTO(
    val id: Long? = null,
    var nome: String,
    var email: String,
    var telefone: String,
    var cpf: String,
    var dataNascimento: LocalDate,
    var aluno: List<AlunoDTO?> = mutableListOf(),
    var endereco: Endereco,
    var motorista: Motorista?
) {

    fun toModel(): ResponseResponsavelDTO {
        return ResponseResponsavelDTO(
            id= this.id,
            nome = this.nome,
            email = this.email,
            telefone = this.telefone,
            cpf = this.cpf,
            dataNascimento = this.dataNascimento,
            endereco = this.endereco,
            motorista = this.motorista,
            aluno = this.aluno
        )
    }

}
