package com.superchat.superchat.config.formatter.external

import java.math.BigDecimal

data class CurrencyBitcoin (
    val last: BigDecimal,
    val buy: BigDecimal,
    val sell: BigDecimal,
    val symbol: String
)
