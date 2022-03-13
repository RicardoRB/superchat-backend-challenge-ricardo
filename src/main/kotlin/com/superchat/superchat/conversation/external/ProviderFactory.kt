package com.superchat.superchat.conversation.external

import com.superchat.superchat.conversation.controller.v1.Platform
import java.util.*

interface ProviderDelegate {
    val platform: Platform
}

abstract class ProviderFactory<K, T : ProviderDelegate>(services: Collection<T>) {
    private val services: EnumMap<Platform, T> = EnumMap(Platform::class.java)

    init {
        for (service in services) {
            this.services[service.platform] = service
        }
    }

    fun of(platform: Platform): T {
        return services[platform] ?: throw java.lang.RuntimeException("Unknown service by platform $platform")
    }
}