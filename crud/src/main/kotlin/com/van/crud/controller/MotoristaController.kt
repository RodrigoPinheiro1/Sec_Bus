package com.van.crud.controller

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
}