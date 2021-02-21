package br.com.gmfonseca.tcc.algorithms

/**
 * Created by Gabriel Fonseca on 31/01/2021.
 */
class BubbleSortAlgorithm<T : Comparable<T>> : SortAlgorithm<T> {

    override fun sort(items: List<T>): List<T> {
        var done: Boolean
        val mutableList = items.toMutableList()

        do {
            done = true
            for (i in 0..mutableList.size - 2) {
                val j = i + 1
                if (mutableList[i] > mutableList[j]) {
                    mutableList.swap(i, j)

                    done = false
                }
            }
        } while (!done)

        return mutableList
    }
}
