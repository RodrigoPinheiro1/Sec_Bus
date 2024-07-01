package com.van.crud.service

import com.van.crud.dto.AlunoDTO
import com.van.crud.dto.CodigoDTO
import com.van.crud.dto.RequestResponsavelDTO
import com.van.crud.dto.ResponseResponsavelDTO
import com.van.crud.exception.MotoristaNotFoundException
import com.van.crud.exception.ResponsavelNotFoundException
import com.van.crud.repository.AlunoRepository
import com.van.crud.repository.MotoristaRepository
import com.van.crud.repository.ResponsavelRepository
import org.springframework.stereotype.Service

@Service
class ResponsavelService(
    private val responsavelRepository: ResponsavelRepository,
    private val alunoRepository: AlunoRepository,
    private val motoristaRepository: MotoristaRepository
) {


    fun cadastrarResponsavel(requestResponsavelDTO: RequestResponsavelDTO): ResponseResponsavelDTO {


        val responsavel = requestResponsavelDTO.toEntity()

        responsavelRepository.save(responsavel)

        return responsavel.toModelResponse()

    }

    fun cadastrarAluno(alunoDTO: AlunoDTO, id: Long): ResponseResponsavelDTO {

        val responsavel = responsavelRepository.findById(id).orElseThrow()

        val aluno = alunoDTO.toEntity()

        aluno.responsavel = responsavel
        alunoRepository.save(aluno)

        return responsavel.toModelResponse()

    }

    fun confirmarCorrida(id: Long, codigoDTO: CodigoDTO): ResponseResponsavelDTO {

        val responsavel = responsavelRepository.findById(id).orElseThrow {
            ResponsavelNotFoundException("Responsavel not found!")
        }

        val motorista = motoristaRepository.findByCodigoSeguranca(codigoDTO.codigo).orElseThrow {
            MotoristaNotFoundException("motorista nao existe")
        }
        responsavel.motorista = motorista
        responsavelRepository.save(responsavel)


        return responsavel.toModelResponse()
    }


}