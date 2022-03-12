package com.superchat.superchat.config.persistance

import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.ZonedDateTime
import javax.persistence.Column
import javax.persistence.EntityListeners
import javax.persistence.MappedSuperclass

@MappedSuperclass
@EntityListeners(AuditingEntityListener::class)
abstract class BaseEntity {

    @Column(updatable = false)
    private var createdAt: ZonedDateTime = ZonedDateTime.now()

    @Column(updatable = true)
    private var updatedAt: ZonedDateTime = ZonedDateTime.now()
}