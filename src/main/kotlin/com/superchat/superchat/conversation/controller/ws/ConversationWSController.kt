package com.superchat.superchat.conversation.controller.ws

import com.superchat.superchat.conversation.ConversationService
import com.superchat.superchat.conversation.dto.SendConversationMessageDto
import org.springframework.messaging.handler.annotation.DestinationVariable
import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.handler.annotation.Payload
import org.springframework.messaging.handler.annotation.SendTo
import org.springframework.stereotype.Controller
import java.util.*


@Controller
class ConversationWSController(
    private val conversationService: ConversationService
) {

    @MessageMapping("/conversations/{conversationUUID}/messages")
    @SendTo("/topic/conversations/{conversationUUID}")
    fun greeting(
        @DestinationVariable conversationUUID: UUID,
        @Payload payload: String
    ): String {
        // FIXME We are not using spring security to inject the contact,
        // this must be improved with the current user uuid
        conversationService.sendMessage(
            SendConversationMessageDto(
                conversationUUID = conversationUUID,
                message = payload,
                contactUUID = UUID.randomUUID()
            )
        )
        return payload
    }

}