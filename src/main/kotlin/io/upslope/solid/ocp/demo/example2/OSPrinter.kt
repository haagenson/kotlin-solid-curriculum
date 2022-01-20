package io.upslope.solid.ocp.demo.example2


import org.springframework.boot.system.SystemProperties

fun writers(): List<Writer> {
    return listOf(WindowsWriter(), LinuxWriter(), MacWriter())
}

class OSPrinter() {
    fun write(msg: String) {
        writers().forEach { it.write(msg) }
    }
}

interface Writer {
    fun write(msg: String)
}

class WindowsWriter: Writer {
    override fun write(msg: String) {
        if (SystemProperties.get("OS") == "WINDOWS") {
            print(msg + " from Windows\n")
        }
    }
}

class LinuxWriter: Writer {
    override fun write(msg: String) {
        if (SystemProperties.get("OS") == "LINUX") {
            print(msg + " from Linux Land\r")
        }
    }
}

class MacWriter: Writer {
    override fun write(msg: String) {
        if (SystemProperties.get("OS") == "MAC") {
            print(msg + " from Mac World\n\n\n")
        }
    }

}
