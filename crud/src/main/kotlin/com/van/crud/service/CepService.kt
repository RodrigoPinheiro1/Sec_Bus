package com.van.crud.service

import com.van.crud.exception.CepException
import com.van.crud.model.Endereco
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.WebClientResponseException
import org.springframework.web.reactive.function.client.awaitBody


@Service
class CepService(
    private val webClient: WebClient
) {


    suspend fun buscarEndereco(cep: String): Endereco {


        try {


            val endereco = webClient.get().uri("$cep/json")
                .retrieve()
                .awaitBody<Endereco>()

            validarEnderecoNullo(endereco)

            return endereco

        } catch (webClientResponseException: WebClientResponseException) {
            throw RuntimeException("Erro no retorno do serviço :   ${webClientResponseException.message} ")
        }
    }

    fun validarEnderecoNullo(endereco: Endereco) {
        if (endereco.cep == null && endereco.bairro == null
            && endereco.numero == null && endereco.complemento == null
            && endereco.localidade == null && endereco.logradouro == null
        ) {
            throw CepException()
        }
    }

}
