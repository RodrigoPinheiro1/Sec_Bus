package com.van.crud.model

import com.van.crud.dto.MotoristaDTO
import com.van.crud.dto.ResponseMotoristaDTO
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
    var responsavel: List<Responsavel?> = mutableListOf()
) {
    fun toResponseDTO(): ResponseMotoristaDTO {

        return ResponseMotoristaDTO(
            id = this.id,
            nome = nome,
            cpf = cpf,
            telefone = telefone,
            dataDeNascimento = dataDeNascimento,
            cnh = cnh,
            endereco = endereco,
            automovel = automovel.toDTO()
        )
    }

    fun toDTOSingle(): MotoristaDTO {
        return MotoristaDTO(
            id = this.id,
            nome = nome,
            telefone = telefone,
            endereco = endereco,
        )
    }


}
