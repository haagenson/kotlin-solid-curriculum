package io.upslope.solid.srp.demo.example2

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.ArgumentMatchers.anyString
import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean

@SpringBootTest
class TitleServiceTest {
    @Autowired
    @Qualifier("RefactoredTitleService")
    lateinit var titleService: TitleService

    @MockBean
    lateinit var httpService: HTTPService

    @BeforeEach
    fun beforeEach() {
        Mockito.`when`(httpService.getHTML(anyString())).thenReturn("<html><head><title>Google</title></head></html>")
    }

    @Test
    fun retrieveTitleGetsTitleFromAGivenWebAddress() {
        val title = titleService.retrieveTitle("https://google.com")

        assertEquals("Google", title)
    }
}
