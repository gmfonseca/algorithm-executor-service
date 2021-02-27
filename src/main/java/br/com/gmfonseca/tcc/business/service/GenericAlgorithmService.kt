package br.com.gmfonseca.tcc.business.service

interface GenericAlgorithmService {
    fun <T : Comparable<T>> execute(elements: List<T>): List<T>
}