package com.superchat.superchat.config.formatter

import com.superchat.superchat.config.formatter.external.BitcoinClient
import org.apache.commons.text.StringSubstitutor
import org.springframework.stereotype.Component

@Component
class MessageFormatter(
    private val bitcoinClient: BitcoinClient
) {

    /**
     * Format placeholders in a text
     *
     * NOTE: This is just an example, it should be more flexible and verify what placeholders it contains
     * before calling
     */
    fun formatPlaceHolders(text: String): String {
        val prices = bitcoinClient.getActualPrice()
        val formatterValues = mapOf(Pair("bitcoinPrice", prices["USD"]?.last))
        val sub = StringSubstitutor(formatterValues, "{{", "}}")
        return sub.replace(text)
    }

}