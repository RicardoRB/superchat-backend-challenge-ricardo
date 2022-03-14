package com.superchat.superchat.contact

import com.superchat.superchat.contact.dto.ContactDto
import com.superchat.superchat.contact.dto.CreateContactDto
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

/**
 * Contact service
 *
 */
interface ContactService {
    /**
     * Create contact
     *
     * @param createContactDto
     * @return [ContactDto] contact dto
     */
    fun create(createContactDto: CreateContactDto): ContactDto

    /**
     * Get all
     *
     * @param pageable optional pageable
     * @return page [ContactDto]
     */
    fun getAll(pageable: Pageable = Pageable.unpaged()): Page<ContactDto>
}
