package br.com.gmfonseca.tcc.application.rest

import br.com.gmfonseca.tcc.business.service.HeapSortService
import org.springframework.web.bind.annotation.*

@CrossOrigin
@RestController
@RequestMapping("/execute/heap-sort")
class HeapSortController(
    private val heapSortService: HeapSortService
) {

    @GetMapping
    fun execute(@RequestBody elements: List<Int>): List<Int> {
        return heapSortService.execute(elements)
    }

}
