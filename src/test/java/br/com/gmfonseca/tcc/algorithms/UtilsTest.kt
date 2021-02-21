package br.com.gmfonseca.tcc.algorithms

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

/**
 * Created by Gabriel Fonseca on 31/01/2021.
 */
class UtilsTest {

    // region swap
    @Test
    fun testSwap_givenValidParametersToSwap_shouldSwapSuccessfully() {
        // Mock
        val mutableList = mutableListOf(1, 2)
        val expected = mutableListOf(2, 1)

        // Run
        mutableList.swap(0, 1)

        // Assert
        Assertions.assertEquals(expected, mutableList)
    }

    @Test
    fun testSwap_givenInvalidFirstIndexParametersToSwap_shouldThrowsException() {
        // Mock
        val mutableList = mutableListOf<Int>()

        // Assert
        assertThrows<IndexOutOfBoundsException> {
            // Run
            mutableList.swap(0, 1)
        }
    }

    @Test
    fun testSwap_givenInvalidSecondIndexParametersToSwap_shouldThrowsException() {
        // Mock
        val mutableList = mutableListOf(1)

        // Assert
        assertThrows<IndexOutOfBoundsException> {
            // Run
            mutableList.swap(0, 1)
        }
    }

    @Test
    fun testSwap_givenBothInvalidIndexesParametersToSwap_shouldThrowsException() {
        // Mock
        val mutableList = mutableListOf<Int>()

        // Assert
        assertThrows<IndexOutOfBoundsException> {
            // Run
            mutableList.swap(2, 3)
        }
    }
    // endregion

}