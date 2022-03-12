package com.superchat.superchat.conversation

import com.superchat.superchat.conversation.dto.ConversationDto
import com.superchat.superchat.conversation.persistance.ConversationEntity
import com.superchat.superchat.conversation.persistance.ConversationRepository
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException
import org.springframework.stereotype.Service

@Service
class ConversationServiceImpl(private val conversationRepository: ConversationRepository) : ConversationService {

    override fun sendMessage(conversationDto: ConversationDto) {

        val exists = conversationRepository.existsByUUID(conversationDto.conversationUUID)
        if (!exists) {
            // TODO Send exception
        }

        val conversation = conversationRepository.findbyUUID(conversationDto.conversationUUID)

//        conversationRepository.save(ConversationEntity(
//            messages =
//        ))

    }
}