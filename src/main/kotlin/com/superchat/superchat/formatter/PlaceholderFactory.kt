package com.superchat.superchat.formatter

interface PlaceholderDelegate {
    val placeholder: String
}

abstract class PlaceholderFactory<K, T : PlaceholderDelegate>(services: Collection<T>) {
    private val services: HashMap<String, T> = hashMapOf()

    init {
        for (service in services) {
            this.services[service.placeholder] = service
        }
    }

    fun of(placeholder: String): T {
        return services[placeholder] ?: throw RuntimeException("Unknown service by placeholder $placeholder")
    }

    fun getPlaceholders(): Set<String> {
        return services.keys
    }
}