package com.superchat.superchat.conversation_contact.controller.v1

import com.superchat.superchat.conversation.controller.v1.ConversationResponse
import com.superchat.superchat.conversation_contact.ConversationContactServiceImpl
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
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
}