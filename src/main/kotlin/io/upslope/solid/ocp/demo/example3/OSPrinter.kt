package io.upslope.solid.ocp.demo.example3

import org.springframework.boot.system.SystemProperties

fun writers(): List<Writer> {
    return listOf(WindowsWriter(), LinuxWriter(), MacWriter())
}

class OSPrinter() {
    fun write(msg: String) {
        writers().find { it.applies() }?.write(msg)
    }
}

interface Writer {
    fun write(msg: String)
    fun applies(): Boolean
}

class WindowsWriter : Writer {
    override fun write(msg: String) {
        print(msg + " from Windows\n")
    }

    override fun applies(): Boolean {
        return SystemProperties.get("OS") == "WINDOWS"
    }
}

class LinuxWriter : Writer {
    override fun write(msg: String) {
        print(msg + " from Linux Land\r")
    }

    override fun applies(): Boolean {
        return SystemProperties.get("OS") == "LINUX"
    }
}

class MacWriter : Writer {
    override fun write(msg: String) {
        print(msg + " from Mac World\n\n\n")
    }

    override fun applies(): Boolean {
        return SystemProperties.get("OS") == "MAC"
    }
}
