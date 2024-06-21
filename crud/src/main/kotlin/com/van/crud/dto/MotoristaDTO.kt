package com.van.crud.dto

import com.van.crud.model.Endereco
import java.util.*

data class MotoristaDTO(

    var id: Long? = null,

    var nome: String,
    var telefone: String,

    var endereco: Endereco,
) {


}
