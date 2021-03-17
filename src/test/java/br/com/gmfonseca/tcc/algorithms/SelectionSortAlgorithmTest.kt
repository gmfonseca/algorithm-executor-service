package br.com.gmfonseca.tcc.algorithms

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

/**
 * Created by Gabriel Fonseca on 31/01/2021.
 */
class SelectionSortAlgorithmTest {

    private val selectionSortAlgorithm = SelectionSortAlgorithm<Int>()

    @Test
    fun testSort_givenWorstCaseList_shouldReturnsSortedList() {
        // Mock
        val list = mutableListOf(5, 4, 3, 2, 1)
        val expected = mutableListOf(1, 2, 3, 4, 5)

        // Run
        val actual = selectionSortAlgorithm.sort(list)

        // Assert
        Assertions.assertEquals(expected, actual)
    }

    @Test
    fun testSort_givenBestCaseList_shouldReturnsSortedList() {
        // Mock
        val list = mutableListOf(1, 2, 3, 4, 5)
        val expected = mutableListOf(1, 2, 3, 4, 5)

        // Run
        val actual = selectionSortAlgorithm.sort(list)

        // Assert
        Assertions.assertEquals(expected, actual)
    }

    @Test
    fun testSort_givenMediumCaseList_shouldReturnsSortedList() {
        // Mock
        val list = mutableListOf(1, 2, 5, 4, 3)
        val expected = mutableListOf(1, 2, 3, 4, 5)

        // Run
        val actual = selectionSortAlgorithm.sort(list)

        // Assert
        Assertions.assertEquals(expected, actual)
    }

}