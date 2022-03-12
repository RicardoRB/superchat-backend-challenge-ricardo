package com.superchat.superchat.conversation.controller.v1

import com.superchat.superchat.conversation.ConversationService
import com.superchat.superchat.conversation.dto.ConversationDto
import com.superchat.superchat.message.dto.MessageDto
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/api/v1/conversations")
class ConversationController(private val conversationService: ConversationService) {

    @PostMapping("/{conversationUUID}/messages")
    fun postConversationMessage(
        @PathVariable conversationUUID: UUID,
        @RequestBody sendMessageRequest: SendMessageRequest
    ) {
        conversationService.sendMessage(
            ConversationDto(
                conversationUUID = conversationUUID,
                message = MessageDto(
                    data = sendMessageRequest.message
                )
            )
        )
    }

    @GetMapping("/{conversationUUID}/messages")
    fun getConversation() {

    }

}