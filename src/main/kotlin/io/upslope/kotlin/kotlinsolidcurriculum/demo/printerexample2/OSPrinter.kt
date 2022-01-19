package io.upslope.kotlin.kotlinsolidcurriculum.demo.printerexample2

import org.springframework.boot.system.SystemProperties

fun main(args: Array<String>) {
    val writers = listOf(WindowsWriter(), LinuxWriter(), MacWriter())
    val osPrinter = OSPrinter(writers);
    osPrinter.write("Hello, world!")
}

private class OSPrinter(private val writers: List<Writer>) {
    fun write(msg: String) {
        writers.find { it.applies() }?.write(msg)
    }
}

private interface Writer {
    fun write(msg: String)
    fun applies(): Boolean
}

private class WindowsWriter : Writer {
    override fun write(msg: String) {
        print(msg + " from Windows\n")
    }

    override fun applies(): Boolean {
        return SystemProperties.get("OS") == "WINDOWS"
    }
}

private class LinuxWriter : Writer {
    override fun write(msg: String) {
        print(msg + " from Linux Land\r")
    }

    override fun applies(): Boolean {
        return SystemProperties.get("OS") == "LINUX"
    }
}

private class MacWriter : Writer {
    override fun write(msg: String) {
        print(msg + " from Mac World\n\n\n")
    }

    override fun applies(): Boolean {
        return SystemProperties.get("OS") == "MAC"
    }
}

