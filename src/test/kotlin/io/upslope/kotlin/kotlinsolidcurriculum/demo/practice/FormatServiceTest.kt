package io.upslope.kotlin.kotlinsolidcurriculum.demo.practice

import io.upslope.kotlin.kotlinsolidcurriculum.practice.FormatService
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import java.util.stream.Stream

@SpringBootTest
class FormatServiceTest {

    @Autowired
    lateinit var formatService: FormatService

    @ParameterizedTest()
    @MethodSource("fileFormats")
    fun logsAnOperatingSystemAppropriateMessageForWindows(
        message: String,
        format: String,
        expectedMessage: String) {
        assertEquals(expectedMessage, formatService.shout(message, format))
    }

    companion object {
        @JvmStatic
        fun fileFormats(): Stream<Arguments> = Stream.of(
            Arguments.of(
                "Have a \"terrible\" day",
                "XML",
                "<msg>HAVE A \"TERRIBLE\" DAY!!</msg>"
            ),
            Arguments.of(
                "Have a \"nice\" day",
                "JSON",
                "{\"msg\": \"HAVE A \\\"NICE\\\" DAY!!\"}"
            ),
            Arguments.of(
                "Have an \"ok\" day",
                "YAML",
                "---\n\nmsg: HAVE AN \"OK\" DAY!!"
            ),
            Arguments.of(
                "Have \"some\" day",
                "NON_EXISTENT",
                "File format NON_EXISTENT is not supported."
            )
        )
    }
}
