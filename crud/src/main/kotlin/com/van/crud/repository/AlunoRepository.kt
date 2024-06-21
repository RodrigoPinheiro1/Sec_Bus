package com.van.crud.repository

import com.van.crud.model.Aluno
import com.van.crud.model.Motorista
import com.van.crud.model.Responsavel
import org.springframework.data.jpa.repository.JpaRepository

interface AlunoRepository : JpaRepository<Aluno, Long> {
}