package com.superchat.superchat.formatter

import org.springframework.stereotype.Component


interface PlaceholderHandler : PlaceholderDelegate {
    fun value(): String
}

@Component
class PlaceholderHandlerFactory(services: List<PlaceholderHandler>) :
    PlaceholderFactory<String, PlaceholderHandler>(services)