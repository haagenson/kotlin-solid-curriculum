package io.upslope.solid.srp.demo.example2

import org.springframework.stereotype.Component

@Component
class HTMLParser {
    fun getTitle(html: String): String? {
        val titleRegex = "<title>(.*?)</title>".toRegex()
        return titleRegex.find(html)?.groups?.get(1)?.value
    }
}
