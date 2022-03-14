package com.superchat.superchat.formatter

import org.apache.commons.text.StringSubstitutor
import org.springframework.stereotype.Component

/**
 * Placeholder formatter
 *
 * @property placeholderHandlerFactory
 */
@Component
class PlaceholderFormatter(
    private val placeholderHandlerFactory: PlaceholderHandlerFactory
) {

    /**
     * Format place holders
     *
     * @param text text with placeholders
     * @param extraFormatter include optionals placeholders
     * @return text with placeholders replaced
     */
    fun formatPlaceHolders(text: String, extraFormatter: Map<String, String> = emptyMap()): String {
        val formatterValues = hashMapOf<String, String>()

        val placeholders = placeholderHandlerFactory.getPlaceholders()
        for (placeholder in placeholders) {
            if (text.contains(placeholder)) {
                val placeholderValue = placeholderHandlerFactory.of(placeholder).value()
                formatterValues[placeholder] = placeholderValue
            }
        }

        val mapTogether = formatterValues + extraFormatter
        val sub = StringSubstitutor(mapTogether, "{{", "}}")
        return sub.replace(text)
    }

}