package com.superchat.superchat.conversation

import com.superchat.superchat.config.exception.NotFoundException
import com.superchat.superchat.conversation.dto.SendConversationMessageDto
import com.superchat.superchat.conversation.external.ProviderConversationFactory
import com.superchat.superchat.conversation.persistance.ConversationRepository
import com.superchat.superchat.message.persistance.MessageEntity
import org.springframework.stereotype.Service

@Service
class ConversationServiceImpl(
    private val conversationRepository: ConversationRepository,
    private val providerConversationFactory: ProviderConversationFactory
) : ConversationService {

    override fun sendMessage(sendConversationMessageDto: SendConversationMessageDto) {

        val conversation = conversationRepository.findByUuid(sendConversationMessageDto.conversationUUID)
            ?: throw NotFoundException("Conversation ${sendConversationMessageDto.conversationUUID} not found")

        val providerFactory = providerConversationFactory.of(conversation.platform)
        providerFactory.sendMessage(
            externalId = conversation.externalId,
            message = sendConversationMessageDto.message
        )

        conversation.messages.add(
            MessageEntity(
                data = sendConversationMessageDto.message
            )
        )

        conversationRepository.save(conversation)

    }
}