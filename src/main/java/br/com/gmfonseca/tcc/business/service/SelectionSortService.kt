package br.com.gmfonseca.tcc.business.service

import br.com.gmfonseca.tcc.algorithms.SelectionSortAlgorithm
import org.springframework.stereotype.Service

@Service
class SelectionSortService {

    fun execute(elements: List<Int>): List<Int> {
        return SelectionSortAlgorithm<Int>().sort(elements)
    }

}
