package com.superchat.superchat

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@SpringBootApplication
@EnableFeignClients
class SuperchatApplication

fun main(args: Array<String>) {
    runApplication<SuperchatApplication>(*args)
}
