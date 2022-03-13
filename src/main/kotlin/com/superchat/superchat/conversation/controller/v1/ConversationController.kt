package com.superchat.superchat.conversation.controller.v1

import com.superchat.superchat.conversation.ConversationService
import com.superchat.superchat.conversation.dto.SendConversationMessageDto
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/api/v1/conversations")
class ConversationController(private val conversationService: ConversationService) {

    @PostMapping
    fun postConversationMessage(
        @PathVariable conversationUUID: UUID,
        @RequestBody sendMessageRequest: CreateConversationRequest
    ) {
        conversationService.sendMessage(
            SendConversationMessageDto(
                conversationUUID = conversationUUID,
                message = sendMessageRequest.message
            )
        )
    }

}