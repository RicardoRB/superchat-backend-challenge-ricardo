package com.superchat.superchat.contact.controller.v1

import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank

data class CreateContactRequest(
    @field:NotBlank
    val name: String,
    @field:Email
    val email: String,
)