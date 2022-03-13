package com.superchat.superchat.conversation.persistance

import com.superchat.superchat.config.persistance.BaseEntity
import com.superchat.superchat.contact.persistance.ContactEntity
import com.superchat.superchat.conversation.controller.v1.Platform
import com.superchat.superchat.message.persistance.MessageEntity
import java.io.Serializable
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "conversations")
class ConversationEntity(
    @ManyToMany(mappedBy = "conversations")
    var contacts: MutableList<ContactEntity>,
    @ManyToMany(mappedBy = "conversations")
    var messages: MutableList<MessageEntity> = mutableListOf(),
    @Column
    var platform: Platform,
    @Column
    var externalId: String,
) : BaseEntity(), Serializable {

    @Id
    @GeneratedValue
    var id: Long = 0

    @Column(unique = true)
    var uuid: UUID = UUID.randomUUID()

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as ConversationEntity

        if (contacts != other.contacts) return false
        if (messages != other.messages) return false
        if (id != other.id) return false
        if (uuid != other.uuid) return false

        return true
    }

    override fun hashCode(): Int {
        var result = contacts.hashCode()
        result = 31 * result + messages.hashCode()
        result = 31 * result + id.hashCode()
        result = 31 * result + uuid.hashCode()
        return result
    }

}