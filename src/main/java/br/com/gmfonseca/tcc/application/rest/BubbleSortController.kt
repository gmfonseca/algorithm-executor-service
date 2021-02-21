package br.com.gmfonseca.tcc.application.rest

import br.com.gmfonseca.tcc.business.service.BubbleSortService
import org.springframework.web.bind.annotation.*

@CrossOrigin
@RestController
@RequestMapping("/execute/bubble-sort")
class BubbleSortController(
    private val bubbleSortService: BubbleSortService
) {

    @GetMapping
    fun execute(@RequestParam type: String, @RequestBody elements: List<Int>): List<Int> {
        return bubbleSortService.execute(elements)
    }

}
