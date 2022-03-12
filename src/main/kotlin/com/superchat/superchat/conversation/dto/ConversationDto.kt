package com.superchat.superchat.conversation.dto

import com.superchat.superchat.message.dto.MessageDto
import java.util.*

data class ConversationDto(
    val conversationUUID: UUID,
    val message: MessageDto,
)