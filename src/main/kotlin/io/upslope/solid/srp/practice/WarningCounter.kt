package io.upslope.solid.practice

import org.springframework.stereotype.Component

data class LogEntry(
    val level: String,
    val date: String,
    val app: String,
    val message: String
)

@Component
class WarningCounter {

    fun countWarnings(lines: List<String>): Int {
        val entries = lines.map {
            val parts = it.split(" ", limit = 4)
            LogEntry(parts[0], parts[1], parts[2], parts[3])
        }

        // pretend this is complicated business logic
        val warnings = entries.filter { it.level == "WARN" }.size

        return warnings
    }

}
