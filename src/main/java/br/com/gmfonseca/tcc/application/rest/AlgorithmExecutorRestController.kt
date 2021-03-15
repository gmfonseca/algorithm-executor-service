package br.com.gmfonseca.tcc.application.rest

import br.com.gmfonseca.tcc.business.dto.SortDataDto
import br.com.gmfonseca.tcc.business.model.AnComparableObject
import br.com.gmfonseca.tcc.business.service.BubbleSortService
import br.com.gmfonseca.tcc.business.service.GenericAlgorithmService
import br.com.gmfonseca.tcc.business.service.HeapSortService
import br.com.gmfonseca.tcc.business.service.SelectionSortService
import br.com.gmfonseca.tcc.proto.AlgorithmExecutor.DataType
import com.google.gson.Gson
import org.springframework.web.bind.annotation.*

@CrossOrigin
@RestController
@JvmSuppressWildcards
@RequestMapping("/execute")
class AlgorithmExecutorRestController(
    private val bubbleSortService: BubbleSortService,
    private val selectionSortService: SelectionSortService,
    private val heapSortService: HeapSortService
) {

    @PostMapping("/bubble-sort")
    fun executeBubbleSort(@RequestBody body: SortDataDto): List<Any> {
        return execute(bubbleSortService, body.type, body.elements.toTypedArray())
    }

    @PostMapping("/selection-sort")
    fun executeSelectionSort(@RequestBody body: SortDataDto): List<Any> {
        return execute(selectionSortService, body.type, body.elements.toTypedArray())
    }

    @PostMapping("/heap-sort")
    fun executeHeapSort(@RequestBody body: SortDataDto): List<Any> {
        return execute(heapSortService, body.type, body.elements.toTypedArray())
    }

    @Suppress("UNCHECKED_CAST")
    private fun execute(
        service: GenericAlgorithmService,
        type: String,
        elements: Array<Any>
    ): List<Any> {
        println("Start running ${service.name} for ${elements.size} elements and typeof ${type.title()}")

        val result = when (DataType.valueOf(type)) {
            DataType.FLOAT -> service.execute(elements.toList() as List<Float>)
            DataType.INTEGER -> service.execute(elements.toList() as List<Int>)
            DataType.OBJECT -> service.execute(elements.toAnComparableObjectList())
            else -> throw IllegalArgumentException("Invalid parameter type $type. Expected one of: ${DataType.values()}.")
        }

        println("Successfully run ${service.name} for ${elements.size} elements and typeof ${type.title()}")
        println()

        return result
    }
}

fun String.title(): String {
    return "${first().toUpperCase()}${substring(1).toLowerCase()}"
}

fun Array<Any>.toAnComparableObjectList(): List<AnComparableObject> {
    val gson = Gson()
    return map { gson.fromJson(it.toString(), AnComparableObject::class.java) }
}
