package com.van.crud.exception

import java.time.LocalDateTime

data class MessageError(
    val data: LocalDateTime,
    val status: Int,
    val message: String,
    val errorValidation: List<ErrorValidation>
) {
}