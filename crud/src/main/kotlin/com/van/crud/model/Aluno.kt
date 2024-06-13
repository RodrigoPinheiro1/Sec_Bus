package com.van.crud.model

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

    @ManyToOne
    private var responsavel: Responsavel




 )
