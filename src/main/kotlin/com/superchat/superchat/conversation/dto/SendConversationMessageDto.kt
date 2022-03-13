package com.superchat.superchat.conversation.dto

import java.util.*

data class SendConversationMessageDto(
    val conversationUUID: UUID,
    val message: String,
)