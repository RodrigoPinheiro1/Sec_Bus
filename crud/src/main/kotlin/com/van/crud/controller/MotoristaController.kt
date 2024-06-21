package com.van.crud.controller

import com.van.crud.dto.RequestMotoristaDTO
import com.van.crud.dto.ResponseMotoristaDTO
import com.van.crud.service.MotoristaService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/motoristas")
class MotoristaController(val motoristaService: MotoristaService) {


    @PostMapping
    fun cadastroMotorista(@RequestBody @Valid motorista: RequestMotoristaDTO): ResponseEntity<ResponseMotoristaDTO> {

        val cadastrarMotorista = motoristaService.cadastrarMotorista(motorista)


        return ResponseEntity(cadastrarMotorista, HttpStatus.CREATED)
    }
}