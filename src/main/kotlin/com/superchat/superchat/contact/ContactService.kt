package com.superchat.superchat.contact

import com.superchat.superchat.contact.dto.ContactDto
import com.superchat.superchat.contact.dto.CreateContactDto
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

interface ContactService {
    fun create(createContactDto: CreateContactDto): ContactDto
    fun getAll(pageable: Pageable = Pageable.unpaged()): Page<ContactDto>
}
