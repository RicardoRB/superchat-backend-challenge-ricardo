package com.superchat.superchat.conversation

import com.superchat.superchat.conversation.controller.v1.ConversationResponse
import com.superchat.superchat.conversation.dto.ConversationDto
import com.superchat.superchat.conversation.dto.SendConversationMessageDto
import java.util.*

interface ConversationService {
    /**
     * Send a message to a specific conversation
     *
     * @param sendConversationMessageDto information about message conversation
     */
    fun sendMessage(sendConversationMessageDto: SendConversationMessageDto)
    fun getAllByContactUuid(contactUUID: UUID): Collection<ConversationDto>
}