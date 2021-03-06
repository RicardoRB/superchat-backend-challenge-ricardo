package com.superchat.superchat.contact.controller.v1

import com.superchat.superchat.contact.ContactMapper
import com.superchat.superchat.contact.ContactService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

/**
 * Contact controller
 *
 * @property contactService
 */
@RestController
@RequestMapping("/api/v1/contacts")
class ContactController(private val contactService: ContactService) {

    /**
     * Post create contact
     *
     * @param createContactRequest
     * @return
     */
    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping
    fun post(@RequestBody createContactRequest: CreateContactRequest): CreateContactResponse {
        val dto = ContactMapper.createContactRequestToCreateContactDto(createContactRequest)
        val response = contactService.create(dto)
        return ContactMapper.contactDtoToCreateContactResponse(response)
    }

    /**
     * Get all contacts
     *
     * @param pageable pagination and sorts
     * @return page [ContactResponse]
     */
    @GetMapping
    fun get(@PageableDefault(page = 0, size = 16) pageable: Pageable): Page<ContactResponse> {
        val response = contactService.getAll(pageable)
        return ContactMapper.contactDtoPageToContactResponsePage(response)
    }

}