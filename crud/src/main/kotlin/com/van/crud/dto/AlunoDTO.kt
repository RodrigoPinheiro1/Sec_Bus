package com.van.crud.dto

import com.van.crud.model.Aluno
import java.time.LocalDate

data class AlunoDTO(

    var id: Long? = null,
    var nome: String,
    var dataNascimento: LocalDate,
    var telefone: String?,
    var embarcado: Boolean = false


) {
    fun toEntity(): Aluno {


        return Aluno(
            nome = this.nome,
            dataNascimento = dataNascimento,
            telefone = this.telefone,
            embarcado = this.embarcado,
            responsavel = null
        )

    }


}
