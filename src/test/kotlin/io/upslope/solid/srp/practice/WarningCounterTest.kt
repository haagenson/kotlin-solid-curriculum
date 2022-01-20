package io.upslope.solid.srp.practice

import io.upslope.solid.practice.WarningCounter
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class WarningCounterTest {
    @Autowired
    lateinit var warningCounter: WarningCounter

    @Test
    fun returnsZeroForNoWarningMessages() {
        val logLines = listOf(
            "INFO 2021-01-02 app1 hello world",
        )

        val warningCount = warningCounter.countWarnings(logLines)

        assertEquals(0, warningCount)
    }

    @Test
    fun providesACountOfWarningMessages() {
        val logLines = listOf(
            "INFO 2021-01-02 app1 hello world",
            "WARN 2021-01-02 app1 oh no!",
            "INFO 2021-01-02 app1 hello world",
            "DEBUG 2021-01-02 app1 hello world",
            "WARN 2021-01-02 app1 hello world",
        )

        val warningCount = warningCounter.countWarnings(logLines)

        assertEquals(2, warningCount)
    }
}
