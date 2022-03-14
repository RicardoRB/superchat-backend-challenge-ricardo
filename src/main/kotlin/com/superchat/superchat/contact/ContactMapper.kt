package com.superchat.superchat.contact

import com.superchat.superchat.contact.controller.v1.ContactResponse
import com.superchat.superchat.contact.controller.v1.CreateContactRequest
import com.superchat.superchat.contact.controller.v1.CreateContactResponse
import com.superchat.superchat.contact.dto.ContactDto
import com.superchat.superchat.contact.dto.CreateContactDto
import com.superchat.superchat.contact.persistance.ContactEntity
import org.springframework.data.domain.Page

/**
 * Contact mapper
 *
 */
class ContactMapper {
    companion object {
        fun createContactRequestToCreateContactDto(createContactRequest: CreateContactRequest) =
            CreateContactDto(
                name = createContactRequest.name,
                email = createContactRequest.email
            )

        fun contactDtoToCreateContactResponse(contactDto: ContactDto) = CreateContactResponse(
            uuid = contactDto.uuid,
            name = contactDto.name,
            email = contactDto.email
        )

        fun contactEntityToContactDto(contactEntity: ContactEntity) = ContactDto(
            id = contactEntity.id,
            uuid = contactEntity.uuid,
            name = contactEntity.name,
            email = contactEntity.email
        )

        fun contactDtoPageToContactResponsePage(page: Page<ContactDto>) = page.map {
            contactDtoToContactResponse(it)
        }

        fun contactEntityPageToContactDtoPage(page: Page<ContactEntity>) = page.map {
            contactEntityToContactDto(it)
        }

        private fun contactDtoToContactResponse(contactDto: ContactDto) = ContactResponse(
            uuid = contactDto.uuid,
            name = contactDto.name,
            email = contactDto.email
        )

    }
}