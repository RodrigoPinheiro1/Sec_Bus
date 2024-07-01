package com.van.crud.service

import com.van.crud.dto.*
import com.van.crud.model.Aluno
import com.van.crud.repository.AlunoRepository
import com.van.crud.repository.MotoristaRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.security.SecureRandom
import java.util.*
import java.util.stream.Collectors

@Service
class MotoristaService(
    val motoristaRepository: MotoristaRepository,
    val alunoRepository: AlunoRepository
) {
    fun cadastrarMotorista(requestMotoristaDTO: RequestMotoristaDTO): ResponseMotoristaDTO {


        val motorista = requestMotoristaDTO.toEntity()

        motorista.codigoSeguranca = generateSecurityCode()

        motoristaRepository.save(motorista)

        return motorista.toResponseDTO()
    }

    fun buscarMotoristas(pagable: Pageable, cidade: String): Page<MotoristaDTO> {

        return motoristaRepository.findAllByEnderecoCidade(pagable, cidade).map {
            it.toDTOSingle()
        }


    }

    fun buscarMotoristasId(id: Long): MotoristaDTO {

        val motorista = motoristaRepository.findById(id).orElseThrow()

        return motorista.toDTOSingle()
    }


    fun generateSecurityCode(length: Int = 8): String {
        val chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"
        val secureRandom = SecureRandom()
        val sb = StringBuilder(length)
        for (i in 0 until length) {
            val randomIndex = secureRandom.nextInt(chars.length)
            sb.append(chars[randomIndex])
        }
        return sb.toString()
    }

    fun checkListAlunos(id: Long): EmbarqueDTO {

        val alunoDTOS = alunoRepository.findMotoristaComAlunos(id)
            .map { aluno -> aluno.toDto() }

        return EmbarqueDTO(alunoDTOS)
    }


}
