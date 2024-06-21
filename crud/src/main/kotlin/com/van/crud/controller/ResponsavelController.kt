package com.van.crud.controller

import com.van.crud.dto.AlunoDTO
import com.van.crud.dto.RequestResponsavelDTO
import com.van.crud.dto.ResponseResponsavelDTO
import com.van.crud.service.ResponsavelService
import jakarta.validation.Valid
import jakarta.validation.constraints.NotNull
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/responsaveis")
class ResponsavelController(private val service: ResponsavelService) {


    @PostMapping
    fun cadastroResponsavel(@Valid @RequestBody requestResponsavelDTO: RequestResponsavelDTO):
            ResponseEntity<ResponseResponsavelDTO> {

        val cadastrarResponsavel = service.cadastrarResponsavel(requestResponsavelDTO)


        return ResponseEntity(cadastrarResponsavel, HttpStatus.CREATED)
    }

    @PostMapping("/alunos/{id}")
    fun cadastroAluno(@Valid @RequestBody alunoDto: AlunoDTO, @NotNull @PathVariable id: Long):
            ResponseEntity<ResponseResponsavelDTO> {

        val cadastrarAluno = service.cadastrarAluno(alunoDto, id)

        return ResponseEntity(cadastrarAluno, HttpStatus.CREATED)

    }


}