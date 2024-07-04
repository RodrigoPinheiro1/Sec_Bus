package com.van.crud.service

import com.van.crud.dto.AlunoDTO
import com.van.crud.dto.CodigoDTO
import com.van.crud.dto.RequestResponsavelDTO
import com.van.crud.dto.ResponseResponsavelDTO
import com.van.crud.repository.AlunoRepository
import com.van.crud.repository.MotoristaRepository
import com.van.crud.repository.ResponsavelRepository
import mu.KotlinLogging
import org.springframework.stereotype.Service

private val log = KotlinLogging.logger {}


@Service
class ResponsavelService(
    private val responsavelRepository: ResponsavelRepository,
    private val alunoRepository: AlunoRepository,
    private val motoristaRepository: MotoristaRepository,
    val notFoundService: NotFoundService
) {


    fun cadastrarResponsavel(requestResponsavelDTO: RequestResponsavelDTO): ResponseResponsavelDTO {


        val responsavel = requestResponsavelDTO.toEntity()


        log.info("salvando responsavel no banco de dados {} ", responsavel)
        responsavelRepository.save(responsavel)

        return responsavel.toModelResponse()

    }


    fun cadastrarAluno(alunoDTO: AlunoDTO, id: Long): ResponseResponsavelDTO {

        val responsavel = notFoundService.findByIdResponsavel(id)

        val aluno = alunoDTO.toEntity()

        aluno.responsavel = responsavel

        log.info { "salvando responsavel aluno {}  $responsavel" }
        alunoRepository.save(aluno)

        return responsavel.toModelResponse()

    }

    fun confirmarCorrida(id: Long, codigoDTO: CodigoDTO): ResponseResponsavelDTO {


        val responsavel = notFoundService.findByIdResponsavel(id)

        val motorista = notFoundService.findByCodigoMotorista(codigoDTO.codigo)

        responsavel.motorista = motorista
        responsavelRepository.save(responsavel)

        log.info { "salvo confirmação, informações disponiveis para motorista {}  $responsavel" }
        return responsavel.toModelResponse()
    }


}