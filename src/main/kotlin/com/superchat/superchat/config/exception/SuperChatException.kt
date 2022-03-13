package com.superchat.superchat.config.exception

open class SuperChatException(
    override val message: String,
    throwable: Throwable? = null
) : Exception(message, throwable)