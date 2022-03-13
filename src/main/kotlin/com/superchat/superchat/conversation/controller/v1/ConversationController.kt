package com.superchat.superchat.conversation.controller.v1

import com.superchat.superchat.conversation.ConversationService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("/api/v1/contacts")
class ConversationController(private val conversationService: ConversationService) {

    @GetMapping
    fun get(): Collection<ConversationResponse> {
        // FIXME We are not using spring security to inject the contact,
        // this must be improved with the current user uuid
        val response = conversationService.getAllByContactUuid(UUID.randomUUID())
        return response.map {
            ConversationResponse(it.uuid)
        }
    }
}