package com.superchat.superchat.conversation.persistance

import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface ConversationRepository : JpaRepository<ConversationEntity, Long> {
    fun findByUuid(conversationUUID: UUID): ConversationEntity?
    fun findAllByContactsUuid(contactUUID: UUID): Collection<ConversationEntity>
}