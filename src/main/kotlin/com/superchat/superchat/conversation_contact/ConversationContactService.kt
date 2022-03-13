package com.superchat.superchat.conversation_contact

import com.superchat.superchat.conversation.dto.ConversationDto
import java.util.*

interface ConversationContactService {
    fun getConversations(contactUUID: UUID): Collection<ConversationDto>
}