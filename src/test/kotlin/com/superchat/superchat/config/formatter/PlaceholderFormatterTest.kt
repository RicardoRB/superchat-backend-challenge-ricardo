package com.superchat.superchat.config.formatter

import com.superchat.superchat.formatter.PlaceholderFormatter
import com.superchat.superchat.formatter.PlaceholderHandlerFactory
import com.superchat.superchat.formatter.delegate.BitcoinClient
import com.superchat.superchat.formatter.delegate.BitcoinPlaceholderDelegate
import com.superchat.superchat.formatter.delegate.CurrencyBitcoinResponse
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

    private lateinit var placeholderHandlerFactory: PlaceholderHandlerFactory

    private lateinit var bitcoinPlaceholderDelegate: BitcoinPlaceholderDelegate

    private lateinit var formatter: PlaceholderFormatter

    @BeforeEach
    fun init() {
        bitcoinPlaceholderDelegate = BitcoinPlaceholderDelegate(bitcoinClient = bitcoinClient)
        placeholderHandlerFactory = PlaceholderHandlerFactory(listOf(bitcoinPlaceholderDelegate))
        formatter = PlaceholderFormatter(
            placeholderHandlerFactory = placeholderHandlerFactory
        )
    }

    @Test
    fun `GIVEN a text with bitcoin placeholder WHEN formatPlaceHolders THEN replace the placeholder with the current bitcoin price in USD`() {

        val expected = "This is the bitcoin price: 39091.81"

        BDDMockito.`when`(bitcoinClient.getActualPrice())
            .thenReturn(
                listOf(
                    CurrencyBitcoinResponse(
                        symbol = "USD",
                        price24H = BigDecimal("39091.81"),
                        volume24H = BigDecimal("39091.81"),
                        lastTradePrice = BigDecimal("39091.81")
                    )
                )
            )

        val result = formatter.formatPlaceHolders("This is the bitcoin price: {{bitcoinPrice}}")

        Assertions.assertEquals(expected, result)

        BDDMockito.verify(bitcoinClient, BDDMockito.atMostOnce())
            .getActualPrice()
    }

}