package br.com.gmfonseca.tcc.business.service

import br.com.gmfonseca.tcc.algorithms.HeapSortAlgorithm
import org.springframework.stereotype.Service

@Service
class HeapSortService {

    fun execute(elements: List<Int>): List<Int> {
        return HeapSortAlgorithm<Int>().sort(elements)
    }

}
