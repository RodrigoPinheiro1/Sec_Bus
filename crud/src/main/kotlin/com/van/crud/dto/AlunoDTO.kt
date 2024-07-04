package com.van.crud.dto

import com.van.crud.model.Aluno
import mu.KotlinLogging
import java.time.LocalDate
private val log = KotlinLogging.logger {}
data class AlunoDTO(

    var id: Long? = null,
    var nome: String,
    var dataNascimento: LocalDate,
    var telefone: String?,
    var embarcado: Boolean = false


) {
    fun toEntity(): Aluno {

        log.info("convertendo DTO para Aluno entidade")

        return Aluno(
            nome = this.nome,
            dataNascimento = dataNascimento,
            telefone = this.telefone,
            embarcado = this.embarcado,
            responsavel = null
        )

    }


}
