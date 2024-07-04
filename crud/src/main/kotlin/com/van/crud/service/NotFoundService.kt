package com.van.crud.service

import com.van.crud.exception.MotoristaNotFoundException
import com.van.crud.exception.ResponsavelNotFoundException
import com.van.crud.model.Motorista
import com.van.crud.model.Responsavel
import com.van.crud.repository.AlunoRepository
import com.van.crud.repository.MotoristaRepository
import com.van.crud.repository.ResponsavelRepository
import mu.KotlinLogging
import org.springframework.stereotype.Component

private val log = KotlinLogging.logger {}

@Component
class NotFoundService(
    val alunoRepository: AlunoRepository,
    val responsavelRepository: ResponsavelRepository,
    val motoristaRepository: MotoristaRepository,
) {


    fun findByIdResponsavel(id: Long): Responsavel {

        log.info("Procurando responsavel pelo id:  $id")
        return responsavelRepository.findById(id).orElseThrow {
            ResponsavelNotFoundException("Responsavel não existe!")
        }
    }


    fun findByCodigoMotorista(codigo: String): Motorista {

        log.info("Procurando motorista pelo codigo de segurança $codigo")
        return motoristaRepository.findByCodigoSeguranca(codigo).orElseThrow {
            MotoristaNotFoundException("motorista não existe")
        }
    }

    fun findByIdMotorista(id: Long): Motorista {
        log.info("Procurando motorista pelo id: $id")
        return motoristaRepository.findById(id).orElseThrow {
            MotoristaNotFoundException("motorista não existe")
        }
    }

}