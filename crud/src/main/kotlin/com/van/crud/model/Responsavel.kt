package com.van.crud.model

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
    var aluno: List<Aluno> = mutableListOf()


    ) {

}
