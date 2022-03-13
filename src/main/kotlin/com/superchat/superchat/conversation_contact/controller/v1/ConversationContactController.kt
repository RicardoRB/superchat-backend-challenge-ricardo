package com.superchat.superchat.conversation_contact.controller.v1

import com.superchat.superchat.conversation.controller.v1.ConversationResponse
import com.superchat.superchat.conversation_contact.ConversationContactServiceImpl
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/api/v1")
class ConversationContactController(private val conversationContactService: ConversationContactServiceImpl) {

    @GetMapping("/contacts/{contactUUID}/conversations")
    fun getConversations(
        @PathVariable contactUUID: UUID,
        @PageableDefault(page = 0, size = 16) pageable: Pageable
    ): Collection<ConversationResponse> {
        val response = conversationContactService.getConversations(contactUUID)
        return response.map {
            ConversationResponse(uuid = it.uuid)
        }
    }

    @PostMapping("/contacts/{contactUUID}/conversations")
    fun postConversationsContact(
        @PathVariable contactUUID: UUID
    ): ConversationResponse {
        val response = conversationContactService.create(contactUUID)
        return ConversationResponse(uuid = response.uuid)
    }
}