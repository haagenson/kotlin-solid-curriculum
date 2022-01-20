package io.upslope.solid.srp.demo.example2

import org.springframework.stereotype.Component
import java.net.HttpURLConnection
import java.net.URL
import java.util.stream.Collectors

@Component("RefactoredTitleService")
class TitleService(private val htmlParser: HTMLParser) {

    fun retrieveTitle(pathOrUrl: String): String? {
        val url = URL(pathOrUrl)

        with(url.openConnection() as HttpURLConnection) {
            requestMethod = "GET"
            val contents = inputStream.bufferedReader().use { it.lines().collect(Collectors.joining("")) }
            return htmlParser.getTitle(contents)
        }
    }

}

