package com.van.crud.model

import com.van.crud.dto.MotoristaDTO
import com.van.crud.dto.ResponseMotoristaDTO
import jakarta.persistence.*
import mu.KotlinLogging
import java.util.*

private val log = KotlinLogging.logger {}

@Entity
data class Motorista(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    var nome: String,

    var cpf: String,

    var codigoSeguranca: String?,

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
    var responsavel: MutableList<Responsavel?> = mutableListOf()
) {
    fun toResponseDTO(): ResponseMotoristaDTO {


        log.info("Convertendo Entidade para DTO Response")

        return ResponseMotoristaDTO(
            id = this.id,
            nome = nome,
            cpf = cpf,
            telefone = telefone,
            dataDeNascimento = dataDeNascimento,
            cnh = cnh,
            endereco = endereco,
            codigoSeguranca = codigoSeguranca ?: "",
            automovel = automovel.toDTO()
        )
    }

    fun toDTOSingle(): MotoristaDTO {

        log.info("Convertendo Entidade para DTO")
        return MotoristaDTO(
            id = this.id,
            nome = nome,
            telefone = telefone,
            endereco = endereco,
        )
    }


}
