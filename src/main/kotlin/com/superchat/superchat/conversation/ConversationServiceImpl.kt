package com.superchat.superchat.conversation

import com.superchat.superchat.config.exception.NotFoundException
import com.superchat.superchat.conversation.dto.SendConversationMessageDto
import com.superchat.superchat.conversation.external.ProviderConversationFactory
import com.superchat.superchat.conversation.persistance.ConversationEntity
import com.superchat.superchat.conversation.persistance.ConversationRepository
import com.superchat.superchat.message.persistance.MessageEntity
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*


@Service
class ConversationServiceImpl(
    private val conversationRepository: ConversationRepository,
    private val providerConversationFactory: ProviderConversationFactory
) : ConversationService {

    private fun findByUuid(conversationUUID: UUID): ConversationEntity {
        return conversationRepository.findByUuid(conversationUUID)
            ?: throw NotFoundException("Conversation $conversationUUID not found")
    }

    @Transactional
    override fun sendMessage(sendConversationMessageDto: SendConversationMessageDto) {

        val conversation = findByUuid(sendConversationMessageDto.conversationUUID)

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