package io.upslope.solid.ocp.demo.example1

import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import org.springframework.boot.test.system.CapturedOutput
import org.springframework.boot.test.system.OutputCaptureExtension
import java.util.stream.Stream

@ExtendWith(OutputCaptureExtension::class)
class OSPrinterTest {

    @AfterEach
    fun clearSystemOSProperty() {
        System.setProperty("OS", "")
    }

    @ParameterizedTest()
    @MethodSource("operatingSystems")
    fun logsAnOperatingSystemAppropriateMessageForWindows(
        osName: String,
        expectedMessage: String,
        output: CapturedOutput
    ) {
        System.setProperty("OS", osName)

        OSPrinter().write("A message")

        assertTrue(output.out.contains(expectedMessage))
    }

    companion object {
        @JvmStatic
        fun operatingSystems(): Stream<Arguments> = Stream.of(
            Arguments.of("WINDOWS", "A message from Windows"),
            Arguments.of("LINUX", "A message from Linux Land\r"),
            Arguments.of("MAC", "A message from Mac World\n\n\n"),
        )
    }
}
