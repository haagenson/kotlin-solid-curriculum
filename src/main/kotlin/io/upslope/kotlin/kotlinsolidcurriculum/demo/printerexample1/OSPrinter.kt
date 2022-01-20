package io.upslope.kotlin.kotlinsolidcurriculum.demo.printerexample1


import org.springframework.boot.system.SystemProperties

fun main(args: Array<String>) {
    val writers = listOf(WindowsWriter(), LinuxWriter(), MacWriter())
    val osPrinter = OSPrinter(writers);
    osPrinter.write("Hello, world!")
}

private class OSPrinter(private val writers: List<Writer>) {
    fun write(msg: String) {
        writers.forEach { it.write(msg) }
    }
}

private interface Writer {
    fun write(msg: String)
}

private class WindowsWriter: Writer {
    override fun write(msg: String) {
        if (SystemProperties.get("OS") == "WINDOWS") {
            print(msg + " from Windows\n")
        }
    }
}

private class LinuxWriter: Writer {
    override fun write(msg: String) {
        if (SystemProperties.get("OS") == "LINUX") {
            print(msg + " from Linux Land\r")
        }
    }
}

private class MacWriter: Writer {
    override fun write(msg: String) {
        if (SystemProperties.get("OS") == "MAC") {
            print(msg + " from Mac World\n\n\n")
        }
    }

}
