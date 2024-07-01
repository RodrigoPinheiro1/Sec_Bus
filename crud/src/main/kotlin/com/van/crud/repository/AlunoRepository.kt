package com.van.crud.repository

import com.van.crud.model.Aluno
import com.van.crud.model.Motorista
import com.van.crud.model.Responsavel
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface AlunoRepository : JpaRepository<Aluno, Long> {



    @Query("select a from Aluno a where a.responsavel.motorista.id = :motoristaId")
    fun findMotoristaComAlunos(motoristaId: Long): List<Aluno>

}