package com.superchat.superchat.contact

import com.superchat.superchat.contact.dto.ContactDto
import com.superchat.superchat.contact.dto.CreateContactDto
import com.superchat.superchat.contact.persistance.ContactEntity
import com.superchat.superchat.contact.persistance.ContactRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.validation.annotation.Validated
import java.util.*
import javax.validation.Valid

@Service
@Validated
class ContactServiceImpl(private val contactRepository: ContactRepository) : ContactService {

    @Transactional
    override fun create(@Valid createContactDto: CreateContactDto): ContactDto {
        val savedContact = contactRepository.save(
            ContactEntity(
                name = createContactDto.name,
                email = createContactDto.email
            )
        )
        return ContactMapper.contactEntityToContactDto(savedContact)
    }

    @Transactional(readOnly = true)
    override fun getAll(pageable: Pageable): Page<ContactDto> {
        val contacts = contactRepository.findAll(pageable)
        return ContactMapper.contactEntityPageToContactDtoPage(contacts)
    }

    override fun getConversations(contactUUID: UUID): Page<ContactDto> {
        TODO("Not yet implemented")
    }
}