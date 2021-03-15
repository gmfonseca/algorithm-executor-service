package br.com.gmfonseca.tcc.business.service

interface GenericAlgorithmService {
    val name: String
    fun <T : Comparable<T>> execute(elements: MutableList<T>): List<T>
}
