package com.van.crud.exception

import java.time.LocalDateTime

data class MessageError(
    val timestamp: LocalDateTime,
    val status: Int,
    val error: String,
    val errors: List<ErrorValidation>
) {
}