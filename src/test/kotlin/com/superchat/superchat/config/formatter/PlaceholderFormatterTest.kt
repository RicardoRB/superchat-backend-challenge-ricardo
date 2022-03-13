package com.superchat.superchat.config.formatter

import com.superchat.superchat.config.formatter.external.BitcoinClient
import com.superchat.superchat.config.formatter.external.CurrencyBitcoin
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.BDDMockito
import org.mockito.Mock
import org.mockito.junit.jupiter.MockitoExtension
import java.math.BigDecimal


@ExtendWith(MockitoExtension::class)
class PlaceholderFormatterTest {

    @Mock
    private lateinit var bitcoinClient: BitcoinClient

    private lateinit var formatter: PlaceholderFormatter

    @BeforeEach
    fun init() {
        formatter = PlaceholderFormatter(
            bitcoinClient = bitcoinClient
        )
    }

    @Test
    fun `GIVEN a text with bitcoin placeholder WHEN formatPlaceHolders THEN replace the placeholder with the current bitcoin price in USD`() {

        val expected = "This is the bitcoin price: 39091.81"

        BDDMockito.`when`(bitcoinClient.getActualPrice())
            .thenReturn(
                hashMapOf(
                    Pair(
                        "USD", CurrencyBitcoin(
                            last = BigDecimal("39091.81"),
                            buy = BigDecimal("39091.81"),
                            sell = BigDecimal("39091.81"),
                            symbol = "USD"
                        )
                    )
                )
            )

        val result = formatter.formatPlaceHolders("This is the bitcoin price: {{bitcoinPrice}}")

        BDDMockito.verify(bitcoinClient, BDDMockito.atMostOnce())
            .getActualPrice()

        Assertions.assertEquals(expected, result)
    }

}