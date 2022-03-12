package com.superchat.superchat.contact.persistance

import org.springframework.data.jpa.repository.JpaRepository

interface ContactRepository : JpaRepository<ContactEntity, Long> {
}