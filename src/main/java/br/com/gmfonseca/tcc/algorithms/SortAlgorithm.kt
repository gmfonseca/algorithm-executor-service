package br.com.gmfonseca.tcc.algorithms

/**
 * A generic collections sorter algorithm. Receives comparable elements, making sort easy.
 */
fun interface SortAlgorithm<T : Comparable<T>> {

    fun sort(items: List<T>): List<T>

}
