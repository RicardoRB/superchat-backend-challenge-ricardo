package com.superchat.superchat.config.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

/**
 * Not found exception
 *
 * @property message message – the detail message (which is saved for later retrieval by the getMessage() method).
 *
 * @param throwable cause – the cause (which is saved for later retrieval by the getCause() method). (A null value is permitted, and indicates that the cause is nonexistent or unknown.)
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
class NotFoundException(override val message: String, throwable: Throwable? = null) :
    SuperChatException(message, throwable)