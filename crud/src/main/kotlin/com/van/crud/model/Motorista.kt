package com.van.crud.model

import jakarta.persistence.*
import java.util.*

@Entity
data class Motorista(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    var nome: String,

    var cpf: String,

    var cnh: String,

    var telefone: String,

    var dataDeNascimento: Date,

    @OneToOne(cascade = [CascadeType.ALL])
    var automovel: Automovel,

//    @Enumerated(EnumType.STRING)
//    var statusPedidoCorrida: StatusPedidoCorrida,

    @Embedded
    var endereco: Endereco,

    @OneToMany(mappedBy = "motorista", cascade = [CascadeType.ALL])
    var responsavel: List<Responsavel> = mutableListOf()
)
