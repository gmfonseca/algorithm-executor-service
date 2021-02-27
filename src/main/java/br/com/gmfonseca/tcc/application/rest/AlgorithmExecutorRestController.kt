package br.com.gmfonseca.tcc.application.rest

import br.com.gmfonseca.tcc.business.service.BubbleSortService
import br.com.gmfonseca.tcc.business.service.GenericAlgorithmService
import br.com.gmfonseca.tcc.business.service.HeapSortService
import br.com.gmfonseca.tcc.business.service.SelectionSortService
import br.com.gmfonseca.tcc.business.service.model.AnComparableObject
import br.com.gmfonseca.tcc.proto.AlgorithmExecutor.DataType
import org.springframework.web.bind.annotation.*

@CrossOrigin
@RestController
@RequestMapping("/execute")
class AlgorithmExecutorRestController(
        private val bubbleSortService: BubbleSortService,
        private val selectionSortService: SelectionSortService,
        private val heapSortService: HeapSortService
) {

    @GetMapping("/heap-sort")
    fun executeHeapSort(@RequestParam type: String, @RequestBody elements: Array<Any>): List<Any> {
        return execute(heapSortService, type, elements)
    }

    @GetMapping("/bubble-sort")
    fun executeBubbleSort(@RequestParam type: String, @RequestBody elements: Array<Any>): List<Any> {
        return execute(bubbleSortService, type, elements)
    }

    @GetMapping("/selection-sort")
    fun executeSelectionSort(@RequestParam type: String, @RequestBody elements: Array<Any>): List<Any> {
        return execute(selectionSortService, type, elements)
    }

    @Suppress("UNCHECKED_CAST")
    private fun execute(
            service: GenericAlgorithmService,
            type: String,
            elements: Array<Any>
    ): List<Any> {
        return when (DataType.valueOf(type)) {
            DataType.FLOAT -> service.execute(elements.toList() as List<Float>)
            DataType.INTEGER -> service.execute(elements.toList() as List<Int>)
            DataType.OBJECT -> service.execute(elements.toList() as List<AnComparableObject>)
            else -> throw IllegalArgumentException("Invalid parameter type $type. Expected one of: ${DataType.values()}.")
        }
    }
}
