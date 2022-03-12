package com.superchat.superchat.contact.controller.v1

import java.util.*

data class ContactResponse(
    val uuid: UUID,
    val name: String,
    val email: String
)