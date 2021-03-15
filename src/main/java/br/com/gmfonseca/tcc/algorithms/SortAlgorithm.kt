package br.com.gmfonseca.tcc.algorithms

/**
 * A generic collections sorter algorithm. Receives comparable elements, making sort easy.
 */
interface SortAlgorithm<T : Comparable<T>> {

    fun sort(items: MutableList<T>): List<T>

}
