package br.com.gmfonseca.tcc.business.service

import br.com.gmfonseca.tcc.algorithms.HeapSortAlgorithm
import org.springframework.stereotype.Service

@Service
class HeapSortService : GenericAlgorithmService {


    override fun <T : Comparable<T>> execute(elements: List<T>): List<T> {
        return HeapSortAlgorithm<T>().sort(elements)
    }
}
