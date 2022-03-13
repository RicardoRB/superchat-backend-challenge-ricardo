package com.superchat.superchat.config.formatter.external

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping

@FeignClient(name = "bitcoin-client", url = "https://blockchain.info")
interface BitcoinClient {
    @GetMapping("/tricker")
    fun getActualPrice(): HashMap<String, CurrencyBitcoin>
}