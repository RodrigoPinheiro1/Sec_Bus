package com.van.crud.service

import com.van.crud.dto.AlunoDTO
import com.van.crud.dto.CodigoDTO
import com.van.crud.dto.RequestResponsavelDTO
import com.van.crud.dto.ResponseResponsavelDTO
import com.van.crud.repository.ResponsavelRepository
import mu.KotlinLogging
import org.springframework.stereotype.Service

private val log = KotlinLogging.logger {}


@Service
class ResponsavelService(
    private val responsavelRepository: ResponsavelRepository,
    val notFoundService: NotFoundService,

    private val cepService: CepService
) {


    suspend fun cadastrarResponsavel(requestResponsavelDTO: RequestResponsavelDTO): ResponseResponsavelDTO {

        val responsavel = requestResponsavelDTO.toEntity()

        val endereco = cepService.buscarEndereco(requestResponsavelDTO.endereco.cep!!)

        responsavel.endereco = endereco
        endereco.numero = responsavel.endereco.numero

        log.info("salvando responsavel no banco de dados {} ", responsavel)
        responsavelRepository.save(responsavel)

        return responsavel.toModelResponse()
    }


    fun cadastrarAluno(alunoDTO: List<AlunoDTO>, id: Long): ResponseResponsavelDTO {

        val responsavel = notFoundService.findByIdResponsavel(id)

        val alunos = alunoDTO.map { it.toEntity(responsavel) }

        responsavel.alunos = alunos.toMutableList()

        responsavelRepository.save(responsavel)

        log.info("atualizado alunos ")

        return responsavel.toModelResponse()

    }

    fun confirmarCorrida(id: Long, codigoDTO: CodigoDTO): ResponseResponsavelDTO {


        val responsavel = notFoundService.findByIdResponsavel(id)

        val motorista = notFoundService.findByCodigoMotorista(codigoDTO.codigo!!)

        responsavel.motorista = motorista

        responsavelRepository.save(responsavel)

        return responsavel.toModelResponse()
    }


}