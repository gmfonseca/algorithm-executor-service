package br.com.gmfonseca.tcc.business.service

import br.com.gmfonseca.tcc.algorithms.SelectionSortAlgorithm
import org.springframework.stereotype.Service

@Service
class SelectionSortService : GenericAlgorithmService {
    override val name: String = "Selection Sort"

    override fun <T : Comparable<T>> execute(elements: MutableList<T>): List<T> {
        return SelectionSortAlgorithm<T>().sort(elements)
    }

}
