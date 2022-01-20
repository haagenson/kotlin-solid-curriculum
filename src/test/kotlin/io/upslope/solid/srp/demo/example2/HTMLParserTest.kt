package io.upslope.solid.srp.demo.example2

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Test

class HTMLParserTest {
    @Test
    fun `#getTitle - Parses the title`() {
        val htmlParser = HTMLParser()
        val content = "<title>American Airlines</title>"

        val title = htmlParser.getTitle(content)

        assertEquals("American Airlines", title)
    }

    @Test
    fun `#getTitle - Returns null for a document with no title`() {
        val htmlParser = HTMLParser()
        val content = ">"

        val title = htmlParser.getTitle(content)

        assertNull(title)
    }

}
