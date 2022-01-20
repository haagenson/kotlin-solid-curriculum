package io.upslope.kotlin.kotlinsolidcurriculum.practice

import org.springframework.stereotype.Component

@Component
class FormatService {
    fun shout(message: String, format: String): String {
        val result = message.uppercase() + "!!"
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
