package br.com.gmfonseca.tcc.application.rest

import br.com.gmfonseca.tcc.business.service.SelectionSortService
import org.springframework.web.bind.annotation.*

/**
 * Created by Gabriel Fonseca on 02/02/2021.
 */
@CrossOrigin
@RestController
@RequestMapping("/execute/selection-sort")
class SelectionSortController(private val selectionSortService: SelectionSortService) {

    @GetMapping
    fun execute(@RequestBody elements: List<Int>): List<Int> {
        return selectionSortService.execute(elements)
    }

}
