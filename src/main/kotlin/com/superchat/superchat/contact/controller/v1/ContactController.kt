package com.superchat.superchat.contact.controller.v1

import com.superchat.superchat.contact.ContactMapper
import com.superchat.superchat.contact.ContactService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/api/v1/contacts")
class ContactController(private val contactService: ContactService) {

    @PostMapping
    fun post(@RequestBody createContactRequest: CreateContactRequest): CreateContactResponse {
        val dto = ContactMapper.createContactRequestToCreateContactDto(createContactRequest)
        val response = contactService.create(dto)
        return ContactMapper.contactDtoToCreateContactResponse(response)
    }

    @GetMapping
    fun get(@PageableDefault(page = 0, size = 16) pageable: Pageable): Page<ContactResponse> {
        val response = contactService.getAll(pageable)
        return ContactMapper.contactDtoPageToContactResponsePage(response)
    }

    @GetMapping("/{contactUUID}/conversations")
    fun getConversations(
        @PathVariable contactUUID: UUID,
        @PageableDefault(page = 0, size = 16) pageable: Pageable
    ): Page<ContactResponse> {
        val response = contactService.getConversations(contactUUID)
        return ContactMapper.contactDtoPageToContactResponsePage(response)
    }
}