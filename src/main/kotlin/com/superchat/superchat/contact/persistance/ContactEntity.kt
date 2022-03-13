package com.superchat.superchat.contact.persistance

import com.superchat.superchat.config.persistance.AuditEntity
import com.superchat.superchat.conversation.persistance.ConversationEntity
import java.io.Serializable
import java.util.*
import javax.persistence.*
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank

@Entity
@Table(name = "contacts")
class ContactEntity(

    @Column
    @field:NotBlank
    var name: String,

    @Column
    @field:Email
    var email: String,

    @Column
    @ManyToMany
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

        other as ContactEntity

        if (id != other.id) return false
        if (uuid != other.uuid) return false
        if (name != other.name) return false
        if (email != other.email) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + uuid.hashCode()
        result = 31 * result + name.hashCode()
        result = 31 * result + email.hashCode()
        return result
    }
}