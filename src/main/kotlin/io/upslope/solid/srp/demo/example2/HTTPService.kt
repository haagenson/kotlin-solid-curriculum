package io.upslope.solid.srp.demo.example2

import org.springframework.stereotype.Component
import java.net.HttpURLConnection
import java.net.URL
import java.util.stream.Collectors

@Component
class HTTPService {
    fun getHTML(pathOrUrl: String): String {
        return with(URL(pathOrUrl).openConnection() as HttpURLConnection) {
            requestMethod = "GET"
            inputStream.bufferedReader().use { it.lines().collect(Collectors.joining("")) }
        }
    }
}
