package com.superchat.superchat.conversation_contact

import com.superchat.superchat.config.exception.NotFoundException
import com.superchat.superchat.contact.persistance.ContactRepository
import com.superchat.superchat.conversation.controller.v1.Platform
import com.superchat.superchat.conversation.dto.ConversationDto
import com.superchat.superchat.conversation.persistance.ConversationEntity
import com.superchat.superchat.conversation.persistance.ConversationRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
class ConversationContactServiceImpl(
    private val conversationRepository: ConversationRepository,
    private val contactRepository: ContactRepository
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

    @Transactional
    override fun create(contactUUID: UUID): ConversationDto {
        val contact = contactRepository.findByUuid(contactUUID)
            ?: throw NotFoundException("Contact not found")

        val conversation = conversationRepository.save(
            ConversationEntity(
                externalId = UUID.randomUUID().toString(),
                platform = Platform.WHATSAPP,
                contacts = mutableListOf(contact)
            )
        )
        return ConversationDto(
            uuid = conversation.uuid
        )
    }
}