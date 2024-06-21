package com.van.crud.model

import com.van.crud.dto.ResponseResponsavelDTO
import jakarta.persistence.*
import java.time.LocalDate

@Entity
data class Responsavel(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    var nome: String,
    var email: String,
    var telefone: String,
    var cpf: String,
    var dataNascimento: LocalDate,
    @OneToMany(mappedBy = "responsavel", cascade = [CascadeType.ALL])
    var aluno: List<Aluno?> = mutableListOf(),

    @Embedded
    var endereco: Endereco,


    @ManyToOne
    var motorista: Motorista?


) {

    fun toModelResponse(): ResponseResponsavelDTO {
        return ResponseResponsavelDTO(
            id = this.id,
            nome = this.nome,
            email = this.email,
            telefone = this.telefone,
            cpf = this.cpf,
            dataNascimento = this.dataNascimento,
            endereco = this.endereco,
            motorista = this.motorista,
            aluno = aluno.map { it?.toDto() }
        )
    }


}



