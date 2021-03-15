package br.com.gmfonseca.tcc.algorithms

/**
 * Created by Gabriel Fonseca on 31/01/2021.
 */
class BubbleSortAlgorithm<T : Comparable<T>> : SortAlgorithm<T> {

    override fun sort(items: MutableList<T>): List<T> {
        var done: Boolean

        do {
            done = true
            for (i in 0..items.size - 2) {
                val j = i + 1
                if (items[i] > items[j]) {
                    items.swap(i, j)

                    done = false
                }
            }
        } while (!done)

        return items
    }
}
