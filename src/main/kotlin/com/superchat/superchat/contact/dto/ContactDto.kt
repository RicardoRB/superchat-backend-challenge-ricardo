package com.superchat.superchat.contact.dto

import java.util.*

data class ContactDto(
    val id: Long,
    val uuid: UUID,
    val name: String,
    val email: String
)