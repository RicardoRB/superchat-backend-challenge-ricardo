package com.superchat.superchat.message.persistance

import com.superchat.superchat.config.persistance.AuditEntity
import com.superchat.superchat.conversation.persistance.ConversationEntity
import java.io.Serializable
import java.util.*
import javax.persistence.*
import javax.validation.constraints.NotBlank

@Entity
@Table(name = "messages")
class MessageEntity(
    @Column
    @field:NotBlank
    var data: String,

    @Column
    @OneToMany
    var conversations: List<ConversationEntity> = emptyList()
) : AuditEntity(), Serializable {

    @Id
    @GeneratedValue
    var id: Long = 0

    @Column(unique = true)
    var uuid: UUID = UUID.randomUUID()


    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as MessageEntity

        if (data != other.data) return false
        if (id != other.id) return false
        if (uuid != other.uuid) return false

        return true
    }

    override fun hashCode(): Int {
        var result = data.hashCode()
        result = 31 * result + id.hashCode()
        result = 31 * result + uuid.hashCode()
        return result
    }


}