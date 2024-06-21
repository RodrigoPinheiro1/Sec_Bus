package com.van.crud.dto

import com.van.crud.model.Endereco
import java.time.LocalDate

data class ResponsavelDTO(
    val id: Long? = null,
    var nome: String,
    var email: String,
    var telefone: String,
    var cpf: String,
    var dataNascimento: LocalDate,
    var aluno: List<AlunoDTO?> = mutableListOf(),
    var endereco: Endereco
) {

}
