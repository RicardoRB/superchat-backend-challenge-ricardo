package com.superchat.superchat.conversation.dto

import java.util.*

data class SendConversationMessageDto(
    val contactUUID: UUID,
    val conversationUUID: UUID,
    val message: String,
)