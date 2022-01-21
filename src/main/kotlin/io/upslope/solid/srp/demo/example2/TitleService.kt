package io.upslope.solid.srp.demo.example2

import org.springframework.stereotype.Component

@Component("RefactoredTitleService")
class TitleService(private val httpService: HTTPService) {

    fun retrieveTitle(pathOrUrl: String): String? {
        val contents = httpService.getHTML(pathOrUrl)
        val titleRegex = "<title>(.*?)</title>".toRegex()
        return titleRegex.find(contents)?.groups?.get(1)?.value
    }

}

