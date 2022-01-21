package io.upslope.solid.srp.demo.example2

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class HTTPServiceTest {

    // NOTE: for the sake of simplicity, this test makes actual network calls
    // In real life you would mock out the HTTP calls using https://github.com/speekha/httpmocker or Wiremock
    @Test
    fun `#getTitle - Parses the title`() {
        val httpService = HTTPService()

        val content = httpService.getHTML("http://example.com/")

        assertTrue(content.contains("<title>Example Domain</title>"))
    }
}
