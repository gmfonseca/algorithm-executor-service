package br.com.gmfonseca.tcc.business.service

interface GenericAlgorithmService {
    val name: String
    fun <T : Comparable<T>> execute(elements: List<T>): List<T>
}
