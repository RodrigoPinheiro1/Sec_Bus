package com.van.crud.repository

import com.van.crud.model.Responsavel
import org.springframework.data.jpa.repository.JpaRepository

interface ResponsavelRepository : JpaRepository<Responsavel, Long> {
}