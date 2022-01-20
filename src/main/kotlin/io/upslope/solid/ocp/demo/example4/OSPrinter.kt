package io.upslope.solid.ocp.demo.example4

import org.springframework.boot.system.SystemProperties
import org.springframework.stereotype.Component

@Component
class OSPrinter(private val writers: List<Writer>) {
    fun write(msg: String) {
        writers.find { it.applies() }?.write(msg)
    }
}

interface Writer {
    fun write(msg: String)
    fun applies(): Boolean
}

@Component
class WindowsWriter : Writer {
    override fun write(msg: String) {
        print(msg + " from Windows\n")
    }

    override fun applies(): Boolean {
        return SystemProperties.get("OS") == "WINDOWS"
    }
}

@Component
class LinuxWriter : Writer {
    override fun write(msg: String) {
        print(msg + " from Linux Land\r")
    }

    override fun applies(): Boolean {
        return SystemProperties.get("OS") == "LINUX"
    }
}

@Component
class MacWriter : Writer {
    override fun write(msg: String) {
        print(msg + " from Mac World\n\n\n")
    }

    override fun applies(): Boolean {
        return SystemProperties.get("OS") == "MAC"
    }
}
