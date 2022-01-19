package io.upslope.kotlin.kotlinsolidcurriculum.practice

fun main(args: Array<String>) {
    val logLines = listOf(
        "INFO 2021-01-02 app1 hello world",
        "WARN 2021-01-02 app1 oh no!",
        "INFO 2021-01-02 app1 hello world",
        "DEBUG 2021-01-02 app1 hello world",
        "WARN 2021-01-02 app1 hello world",
    )

    val warnings = WarningCounter().countWarnings(logLines)
    println("There are $warnings warnings")
}

data class LogEntry(
    val level: String,
    val date: String,
    val app: String,
    val message: String
)

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