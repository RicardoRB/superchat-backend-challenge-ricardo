package com.superchat.superchat.conversation.persistance

import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface ConversationRepository : JpaRepository<ConversationEntity, Long> {
    fun existsByUUID(conversationUUID: UUID): Boolean
    fun findbyUUID(conversationDto.conversationUUID): ConversationEntity?
}