package com.superchat.superchat.conversation.external.whatsapp

import com.superchat.superchat.conversation.controller.v1.Platform
import com.superchat.superchat.conversation.external.ProviderConversation
import org.springframework.stereotype.Component

@Component
class WhatsappDelegate(override val platform: Platform = Platform.WHATSAPP) : ProviderConversation {

    override fun sendMessage(externalId: String, message: String) {
        // Send message to whatsapp
    }
}