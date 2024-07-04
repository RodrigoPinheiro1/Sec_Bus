package com.van.crud.service

import com.van.crud.dto.*
import com.van.crud.repository.AlunoRepository
import com.van.crud.repository.MotoristaRepository
import mu.KotlinLogging

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.security.SecureRandom

private val log = KotlinLogging.logger {}


@Service
class MotoristaService(
    val motoristaRepository: MotoristaRepository,
    val alunoRepository: AlunoRepository,
    val notFoundService: NotFoundService,

    ) {
    fun cadastrarMotorista(requestMotoristaDTO: RequestMotoristaDTO): ResponseMotoristaDTO {


        val motorista = requestMotoristaDTO.toEntity()

        motorista.codigoSeguranca = generateSecurityCode()

        motoristaRepository.save(motorista)

        log.info("salvo motorista {}", motorista)

        return motorista.toResponseDTO()
    }

    fun buscarMotoristas(pagable: Pageable, cidade: String): Page<MotoristaDTO> {


        log.info("buscando enderecos motorista")


        return motoristaRepository.findAllByEnderecoCidade(pagable, cidade).map {
            it.toDTOSingle()
        }

    }

    fun buscarMotoristasId(id: Long): MotoristaDTO {


        log.info("Buscando Motorista por Id")

        val motorista = notFoundService.findByIdMotorista(id)

        return motorista.toDTOSingle()
    }


    fun generateSecurityCode(length: Int = 8): String {

        log.info { "Gerando código de segurança para Motorista" }
        val chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"
        val secureRandom = SecureRandom()
        val sb = StringBuilder(length)
        for (i in 0 until length) {
            val randomIndex = secureRandom.nextInt(chars.length)
            sb.append(chars[randomIndex])
        }

        log.info { "Gerado Codigo {} , $sb" }
        return sb.toString()
    }

    fun checkListAlunos(id: Long): EmbarqueDTO {

        log.info("fazendo busca para check list de alunos")
        val alunoDTOS = alunoRepository.findMotoristaComAlunos(id)
            .map { aluno -> aluno.toDto() }

        return EmbarqueDTO(alunoDTOS)
    }

    fun atualizarEmbarque(id: Long, embarqueDto: EmbarqueDTO): EmbarqueDTO {

        log.info("buscando alunos que estão associados com motorista")

        val alunos = alunoRepository.findMotoristaComAlunos(id)

        alunos.forEach {
            embarqueDto.alunos.forEach { alunoDTO ->
                it.embarcado = alunoDTO!!.embarcado
            }
        }
        log.info("atualizando embarque dos alunos {}", alunos)
        alunoRepository.saveAll(alunos)


        return EmbarqueDTO(alunos.map { aluno -> aluno.toDto() })

    }


}
