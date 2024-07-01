package com.van.crud.model

import com.van.crud.dto.AlunoDTO
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne
import java.time.LocalDate


@Entity
data class Aluno(

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long? = null,
    var nome: String,
    var dataNascimento: LocalDate,
    var telefone: String?,
    var embarcado: Boolean = false,

    @ManyToOne
     var responsavel: Responsavel?
 ){
    fun toDto(): AlunoDTO {
        return AlunoDTO(
            id = this.id,
            nome = this.nome,
            dataNascimento = this.dataNascimento,
            telefone = this.telefone,
            embarcado = this.embarcado
        )
    }


}
