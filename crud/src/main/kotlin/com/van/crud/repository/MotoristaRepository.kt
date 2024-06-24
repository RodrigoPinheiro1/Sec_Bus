package com.van.crud.repository

import com.van.crud.model.Motorista
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import java.util.Optional

interface MotoristaRepository : JpaRepository<Motorista, Long> {


    fun findAllByEnderecoCidade(pageable: Pageable, cidade: String): Page<Motorista>

    fun findByCodigoSeguranca(codigo: String): Optional<Motorista>
}