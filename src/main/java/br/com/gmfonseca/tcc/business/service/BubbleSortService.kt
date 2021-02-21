package br.com.gmfonseca.tcc.business.service

import br.com.gmfonseca.tcc.algorithms.BubbleSortAlgorithm
import org.springframework.stereotype.Service

@Service
class BubbleSortService {

    fun execute(elements: List<Int>): List<Int> {
        return BubbleSortAlgorithm<Int>().sort(elements)
    }

}
