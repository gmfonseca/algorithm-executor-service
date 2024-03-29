package br.com.gmfonseca.tcc.business.service

import br.com.gmfonseca.tcc.algorithms.BubbleSortAlgorithm
import org.springframework.stereotype.Service

@Service
class BubbleSortService : GenericAlgorithmService {
    override val name: String = "Bubble Sort"

    override fun <T : Comparable<T>> execute(elements: MutableList<T>): List<T> {
        return BubbleSortAlgorithm<T>().sort(elements)
    }

}
