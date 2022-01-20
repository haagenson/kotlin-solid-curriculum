package io.upslope.solid.ocp.demo.example1

import org.springframework.boot.system.SystemProperties

fun main(args: Array<String>) {
    val osPrinter = OSPrinter();
    osPrinter.write("Hello, world!")
}

class OSPrinter {
    fun write(msg: String) {
        if (SystemProperties.get("OS") == "WINDOWS") {
            print(msg + " from Windows\n")
        }

        if (SystemProperties.get("OS") == "LINUX") {
            print(msg + " from Linux Land\r")
        }

        if (SystemProperties.get("OS") == "MAC") {
            print(msg + " from Mac World\n\n\n")
        }
    }
}
