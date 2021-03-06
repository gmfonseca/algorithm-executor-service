package br.com.gmfonseca.tcc

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
open class AlgorithmExecutorServiceApplication

fun main(args: Array<String>) {
    runApplication<AlgorithmExecutorServiceApplication>(*args)
}
