package io.upslope.solid.srp.demo.example1

import org.springframework.stereotype.Component
import java.net.HttpURLConnection
import java.net.URL
import java.util.stream.Collectors

@Component
class TitleService {

    fun retrieveTitle(pathOrUrl: String): String? {
        val contents = with(URL(pathOrUrl).openConnection() as HttpURLConnection) {
            requestMethod = "GET"
            inputStream.bufferedReader().use { it.lines().collect(Collectors.joining("")) }
        }

        val titleRegex = "<title>(.*?)</title>".toRegex()
        return titleRegex.find(contents)?.groups?.get(1)?.value
    }

}
