package com.van.crud.dto

import com.van.crud.model.Endereco
import java.util.*

data class ResponseMotoristaDTO(

    var id: Long? = null,

    var nome: String,

    var cpf: String,

    var cnh: String,

    var telefone: String,

    var dataDeNascimento: Date,
    var automovel: AutomovelDTO,

    var endereco: Endereco,

    var responsavel: List<ResponsavelDTO> = mutableListOf()


) {

}
