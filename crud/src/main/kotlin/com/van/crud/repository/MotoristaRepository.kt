package com.van.crud.repository

import com.van.crud.model.Motorista
import com.van.crud.model.Responsavel
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository

interface MotoristaRepository : JpaRepository<Motorista, Long> {


    fun findAllByEnderecoCidade(pageable: Pageable, cidade: String): Page<Motorista>
}