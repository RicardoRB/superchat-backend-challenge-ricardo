package com.superchat.superchat.formatter.delegate

import com.fasterxml.jackson.annotation.JsonProperty
import java.math.BigDecimal

/**
 * Currency bitcoin response
 *
 * @property symbol
 * @property price24H
 * @property volume24H
 * @property lastTradePrice
 */
data class CurrencyBitcoinResponse(
    val symbol: String,
    @JsonProperty("price_24h")
    val price24H: BigDecimal,
    @JsonProperty("volume_24h")
    val volume24H: BigDecimal,
    @JsonProperty("last_trade_price")
    val lastTradePrice: BigDecimal
)
