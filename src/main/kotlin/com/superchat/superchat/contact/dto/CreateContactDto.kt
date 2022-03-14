package com.superchat.superchat.contact.dto

import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank

/**
 * Create contact dto
 *
 * @property name
 * @property email
 */
data class CreateContactDto(
    @field:NotBlank
    val name: String,
    @field:Email
    val email: String,
)