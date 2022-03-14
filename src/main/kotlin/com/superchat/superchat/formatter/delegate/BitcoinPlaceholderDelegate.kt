package com.superchat.superchat.formatter.delegate

import com.superchat.superchat.formatter.PlaceholderHandler
import org.springframework.stereotype.Component
import java.math.BigDecimal

@Component
class BitcoinPlaceholderDelegate(
    override val placeholder: String = "{{bitcoinPrice}}",
    private val bitcoinClient: BitcoinClient
) : PlaceholderHandler {

    override fun value(): String {
        val prices = bitcoinClient.getActualPrice()
        val usd = prices.firstOrNull { it.symbol == "USD" }?.price24H ?: BigDecimal.ZERO
        return usd.toString()
    }

}