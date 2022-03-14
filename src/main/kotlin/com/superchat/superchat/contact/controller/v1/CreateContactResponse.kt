package com.superchat.superchat.contact.controller.v1

import java.util.*
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank

/**
 * Create contact response
 *
 * @property uuid
 * @property name
 * @property email
 */
data class CreateContactResponse(
    val uuid: UUID,
    @field:NotBlank
    val name: String,
    @field:Email
    val email: String,
)