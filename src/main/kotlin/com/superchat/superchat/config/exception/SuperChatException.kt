package com.superchat.superchat.config.exception

/**
 * Superchat Exception
 *
 * @property message message – the detail message (which is saved for later retrieval by the getMessage() method).
 *
 * @param throwable cause – the cause (which is saved for later retrieval by the getCause() method). (A null value is permitted, and indicates that the cause is nonexistent or unknown.)
 */
open class SuperChatException(
    override val message: String,
    throwable: Throwable? = null
) : Exception(message, throwable)