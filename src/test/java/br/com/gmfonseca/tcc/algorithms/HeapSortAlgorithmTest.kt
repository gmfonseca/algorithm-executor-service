package br.com.gmfonseca.tcc.algorithms

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

/**
 * Created by Gabriel Fonseca on 31/01/2021.
 */
class HeapSortAlgorithmTest {

    private val heapSortAlgorithm = HeapSortAlgorithm<Int>()

    @Test
    fun testSort_givenWorstCaseList_shouldReturnsSortedList() {
        // Mock
        val list = listOf(5, 4, 3, 2, 1)
        val expected = listOf(1, 2, 3, 4, 5)

        // Run
        val actual = heapSortAlgorithm.sort(list)

        // Assert
        Assertions.assertEquals(expected, actual)
    }

    @Test
    fun testSort_givenBestCaseList_shouldReturnsSortedList() {
        // Mock
        val list = listOf(1, 2, 3, 4, 5)
        val expected = listOf(1, 2, 3, 4, 5)

        // Run
        val actual = heapSortAlgorithm.sort(list)

        // Assert
        Assertions.assertEquals(expected, actual)
    }

    @Test
    fun testSort_givenMediumCaseList_shouldReturnsSortedList() {
        // Mock
        val list = listOf(1, 2, 5, 4, 3)
        val expected = listOf(1, 2, 3, 4, 5)

        // Run
        val actual = heapSortAlgorithm.sort(list)

        // Assert
        Assertions.assertEquals(expected, actual)
    }

}