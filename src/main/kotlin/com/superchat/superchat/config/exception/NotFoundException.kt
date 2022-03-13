package com.superchat.superchat.config.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(HttpStatus.NOT_FOUND)
class NotFoundException(override val message: String, throwable: Throwable? = null) :
    SuperChatException(message, throwable)