package com.van.crud.service

import com.van.crud.dto.MotoristaDTO
import com.van.crud.dto.RequestMotoristaDTO
import com.van.crud.dto.ResponseMotoristaDTO
import com.van.crud.model.Motorista
import com.van.crud.repository.MotoristaRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class MotoristaService(val motoristaRepository: MotoristaRepository) {
    fun cadastrarMotorista(requestMotoristaDTO: RequestMotoristaDTO): ResponseMotoristaDTO {


        val motorista = requestMotoristaDTO.toEntity()

        motoristaRepository.save(motorista)

        return motorista.toResponseDTO()
    }

    fun buscarMotoristas(pagable: Pageable, cidade: String): Page<MotoristaDTO> {

        return motoristaRepository.findAllByEnderecoCidade(pagable, cidade).map {
            it.toDTOPage()
        }



    }

}
