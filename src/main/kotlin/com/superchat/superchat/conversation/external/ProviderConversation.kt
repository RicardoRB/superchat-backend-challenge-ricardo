package com.superchat.superchat.conversation.external

import com.superchat.superchat.conversation.controller.v1.Platform
import org.springframework.stereotype.Component


interface ProviderConversation : ProviderDelegate {
    fun sendMessage(externalId: String, message: String)
}

@Component
class ProviderConversationFactory(services: List<ProviderConversation>) :
    ProviderFactory<Platform, ProviderConversation>(services)