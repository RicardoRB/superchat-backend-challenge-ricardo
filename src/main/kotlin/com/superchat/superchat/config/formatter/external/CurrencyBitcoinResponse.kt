package com.superchat.superchat.config.formatter.external

import com.fasterxml.jackson.annotation.JsonProperty
import java.math.BigDecimal

data class CurrencyBitcoinResponse(
    val symbol: String,
    @JsonProperty("price_24h")
    val price24H: BigDecimal,
    @JsonProperty("volume_24h")
    val volume24H: BigDecimal,
    @JsonProperty("last_trade_price")
    val lastTradePrice: BigDecimal
)
