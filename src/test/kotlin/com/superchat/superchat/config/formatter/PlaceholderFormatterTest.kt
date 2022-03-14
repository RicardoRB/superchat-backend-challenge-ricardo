package com.superchat.superchat.config.formatter

import com.superchat.superchat.formatter.PlaceholderFormatter
import com.superchat.superchat.formatter.PlaceholderHandlerFactory
import com.superchat.superchat.formatter.delegate.BitcoinPlaceholderDelegate
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.BDDMockito
import org.mockito.Mock
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
class PlaceholderFormatterTest {

    @Mock
    private lateinit var placeholderHandlerFactory: PlaceholderHandlerFactory

    @Mock
    private lateinit var bitcoinPlaceholderDelegate: BitcoinPlaceholderDelegate

    private lateinit var formatter: PlaceholderFormatter

    @BeforeEach
    fun init() {
        formatter = PlaceholderFormatter(
            placeholderHandlerFactory = placeholderHandlerFactory
        )
    }

    @Test
    fun `GIVEN a text with bitcoin placeholder WHEN formatPlaceHolders THEN replace the placeholder with the current bitcoin price in USD`() {

        val expected = "This is the bitcoin price: 39091.81"

        BDDMockito.`when`(placeholderHandlerFactory.getPlaceholders())
            .thenReturn(setOf("{{bitcoinPrice}}"))

        BDDMockito.`when`(placeholderHandlerFactory.of("{{bitcoinPrice}}"))
            .thenReturn(bitcoinPlaceholderDelegate)

        BDDMockito.`when`(bitcoinPlaceholderDelegate.value())
            .thenReturn("39091.81")

        val result = formatter.formatPlaceHolders("This is the bitcoin price: {{bitcoinPrice}}")

        Assertions.assertEquals(expected, result)

        BDDMockito.verify(placeholderHandlerFactory, BDDMockito.atMostOnce())
            .getPlaceholders()

        BDDMockito.verify(placeholderHandlerFactory, BDDMockito.atMostOnce())
            .of("{{bitcoinPrice}}")

        BDDMockito.verify(bitcoinPlaceholderDelegate, BDDMockito.atMostOnce())
            .value()
    }

}