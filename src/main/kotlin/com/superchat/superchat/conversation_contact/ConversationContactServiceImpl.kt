package com.superchat.superchat.conversation_contact

import com.superchat.superchat.conversation.dto.ConversationDto
import com.superchat.superchat.conversation.persistance.ConversationRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
class ConversationContactServiceImpl(
    private val conversationRepository: ConversationRepository
) : ConversationContactService {

    @Transactional(readOnly = true)
    override fun getConversations(contactUUID: UUID): Collection<ConversationDto> {
        val conversations = conversationRepository.findAllByContactsUuid(contactUUID)
        return conversations.map {
            ConversationDto(
                uuid = it.uuid
            )
        }
    }
}