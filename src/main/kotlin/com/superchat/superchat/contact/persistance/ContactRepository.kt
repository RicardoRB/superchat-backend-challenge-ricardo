package com.superchat.superchat.contact.persistance

import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

/**
 * Contact repository
 *
 */
interface ContactRepository : JpaRepository<ContactEntity, Long> {
    /**
     * Find by uuid
     *
     * @param contactUUID contact UUID key
     * @return [ContactEntity] nullable
     */
    fun findByUuid(contactUUID: UUID): ContactEntity?
}