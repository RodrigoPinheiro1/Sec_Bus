package com.van.crud.service

import com.van.crud.dto.RequestMotoristaDTO
import com.van.crud.dto.ResponseMotoristaDTO
import com.van.crud.repository.MotoristaRepository
import org.springframework.stereotype.Service

@Service
class MotoristaService(val motoristaRepository: MotoristaRepository) {
    fun cadastrarMotorista(requestMotoristaDTO: RequestMotoristaDTO): ResponseMotoristaDTO {


        val motorista = requestMotoristaDTO.toEntity()

        motoristaRepository.save(motorista)

        return motorista.toDto()
    }

}
