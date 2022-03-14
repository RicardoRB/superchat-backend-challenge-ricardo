package com.superchat.superchat.config.formatter.external

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping

@FeignClient(name = "bitcoin-client", url = "https://api.blockchain.com/v3/exchange")
interface BitcoinClient {
    @GetMapping("/tickers")
    fun getActualPrice(): Collection<CurrencyBitcoinResponse>
}