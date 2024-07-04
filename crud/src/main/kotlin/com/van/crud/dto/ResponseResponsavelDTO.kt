package com.van.crud.dto

import com.van.crud.model.Endereco
import java.time.LocalDate


data class ResponseResponsavelDTO(
    val id: Long? = null,
    var nome: String,
    var email: String,
    var telefone: String,
    var cpf: String,
    var dataNascimento: LocalDate,
    var alunos: List<AlunoDTO?> = mutableListOf(),
    var endereco: Endereco,
    var motorista: MotoristaDTO?
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
            motorista = null,
            alunos = this.alunos
        )
    }

}
