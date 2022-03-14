package com.superchat.superchat.config.formatter

import com.superchat.superchat.config.formatter.external.BitcoinClient
import org.apache.commons.text.StringSubstitutor
import org.springframework.stereotype.Component
import java.math.BigDecimal

/**
 * Placeholder formatter
 *
 * @property bitcoinClient
 * @constructor Create empty Placeholder formatter
 */
@Component
class PlaceholderFormatter(
    private val bitcoinClient: BitcoinClient
) {

    /**
     * Format place holders
     *
     * @param text text with placeholders
     * @param extraFormatter include optionals placeholders
     * @return text with placeholders replaced
     */
    fun formatPlaceHolders(text: String, extraFormatter: Map<String, String> = emptyMap()): String {
        val prices = bitcoinClient.getActualPrice()
        val usd = prices.firstOrNull { it.symbol == "USD" }?.price24H ?: BigDecimal.ZERO
        val formatterValues = mapOf(Pair("bitcoinPrice", usd))
        val mapTogether = formatterValues + extraFormatter
        val sub = StringSubstitutor(mapTogether, "{{", "}}")
        return sub.replace(text)
    }

}