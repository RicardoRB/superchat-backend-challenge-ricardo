package com.superchat.superchat.conversation

import com.superchat.superchat.conversation.dto.SendConversationMessageDto

interface ConversationService {
    fun sendMessage(sendConversationMessageDto: SendConversationMessageDto)
}