package io.upslope.kotlin.kotlinsolidcurriculum.demo

import java.net.HttpURLConnection
import java.net.URL
import java.util.stream.Collectors

fun main(args: Array<String>) {
    SingleResponsibility().doStuff("https://google.com")
}


class SingleResponsibility {

    fun doStuff(pathOrUrl: String) {
        val url = URL(pathOrUrl)

        with(url.openConnection() as HttpURLConnection) {
            requestMethod = "GET"
            val contents = inputStream.bufferedReader().use { it.lines().collect(Collectors.joining("")) }
            val titleRegex = "<title>(.*?)</title>".toRegex()
            println(titleRegex.find(contents)?.groups?.get(1)?.value)
        }

    }

}