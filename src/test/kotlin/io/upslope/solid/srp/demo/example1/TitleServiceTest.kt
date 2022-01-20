package io.upslope.solid.srp.demo.example1

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class TitleServiceTest {
    @Autowired
    lateinit var titleService: TitleService

    @Test
    fun retrieveTitleGetsTitleFromAGivenWebAddress() {
        val title = titleService.retrieveTitle("https://google.com")

        assertEquals("Google", title)
    }

    @Test
    fun retrieveTitleGetsTitleFromADifferentGivenWebAddress() {
        val title = titleService.retrieveTitle("https://example.com")

        assertEquals("Example Domain", title)
    }
}
