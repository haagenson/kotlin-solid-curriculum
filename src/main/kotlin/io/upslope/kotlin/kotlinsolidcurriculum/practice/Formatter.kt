package io.upslope.kotlin.kotlinsolidcurriculum.practice

fun main(args: Array<String>) {
    println(Formatter("Have a \"terrible\" day", "XML").shout())
    println(Formatter("Have a \"nice\" day", "JSON").shout())
    println(Formatter("Have an \"ok\" day", "YAML").shout())
    println(Formatter("Have \"some\" day", "NON_EXISTENT").shout())
}

class Formatter(private val msg: String, private val format: String) {
    fun shout(): String {
        val result = msg.uppercase() + "!!"
        return when (format) {
            "XML" -> "<msg>$result</msg>"
            "JSON" -> {
                val escaped = result.replace("\"", "\\\"")
                return "{\"msg\": \"$escaped\"}"
            }
            "YAML" -> "---\n\nmsg: $result"
            else -> "File format $format is not supported."
        }
    }
}
