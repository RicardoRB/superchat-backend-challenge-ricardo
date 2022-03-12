package com.superchat.superchat.conversation

import com.superchat.superchat.conversation.dto.ConversationDto

interface ConversationService {
    fun sendMessage(conversationDto: ConversationDto)
}