package com.van.crud.controller

import com.van.crud.dto.EmbarqueDTO
import com.van.crud.dto.MotoristaDTO
import com.van.crud.dto.RequestMotoristaDTO
import com.van.crud.dto.ResponseMotoristaDTO
import com.van.crud.service.MotoristaService
import jakarta.validation.Valid
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/motoristas")
class MotoristaController(val motoristaService: MotoristaService) {


    @PostMapping
    fun cadastrarMotorista(@RequestBody @Valid motorista: RequestMotoristaDTO): ResponseEntity<ResponseMotoristaDTO> {

        val cadastrarMotorista = motoristaService.cadastrarMotorista(motorista)


        return ResponseEntity(cadastrarMotorista, HttpStatus.CREATED)
    }

    @GetMapping
    fun buscarMotoristas(pagable: Pageable, @RequestParam cidade: String): Page<MotoristaDTO> {

        return motoristaService.buscarMotoristas(pagable, cidade)

    }

    @GetMapping("/{id}")
    fun buscarMotoristasPorId(@PathVariable id: Long): MotoristaDTO {

        return motoristaService.buscarMotoristasId(id)

    }

//    @PostMapping("/embarques/{id}")
//    fun embarque(@PathVariable id: Long, @RequestBody embarqueDto: EmbarqueDTO) : ResponseEntity<String> {
//
//
//
//        return
//    }


    @GetMapping("/embarques/{id}")
    fun checkListAlunos(@PathVariable id: Long): ResponseEntity<EmbarqueDTO> {


        val checkListAlunos = motoristaService.checkListAlunos(id)


        return ResponseEntity(checkListAlunos, HttpStatus.OK)
    }


}