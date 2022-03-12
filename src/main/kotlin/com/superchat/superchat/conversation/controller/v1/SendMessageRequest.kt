package com.superchat.superchat.conversation.controller.v1

enum class Platform {
    WHATSAPP
}

data class SendMessageRequest(
    val message: String,
    val platform: Platform
)