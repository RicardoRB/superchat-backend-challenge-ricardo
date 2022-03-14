package com.superchat.superchat.contact.dto

import java.util.*

/**
 * Contact dto
 *
 * @property id
 * @property uuid
 * @property name
 * @property email
 */
data class ContactDto(
    val id: Long,
    val uuid: UUID,
    val name: String,
    val email: String
)