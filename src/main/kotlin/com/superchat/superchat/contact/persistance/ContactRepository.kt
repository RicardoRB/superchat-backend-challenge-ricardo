package com.superchat.superchat.contact.persistance

import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface ContactRepository : JpaRepository<ContactEntity, Long> {
    fun findByUuid(contactUUID: UUID): ContactEntity?
}