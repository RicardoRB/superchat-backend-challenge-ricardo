package com.superchat.superchat.contact.controller.v1

import java.util.*

/**
 * Contact response
 *
 * @property uuid
 * @property name
 * @property email
 */
data class ContactResponse(
    val uuid: UUID,
    val name: String,
    val email: String
)