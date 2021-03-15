package br.com.gmfonseca.tcc.algorithms

/**
 * Created by Gabriel Fonseca on 31/01/2021.
 */
class SelectionSortAlgorithm<T : Comparable<T>> : SortAlgorithm<T> {

    override fun sort(items: MutableList<T>): List<T> {

        for (i in items.indices) {
            var lower = i
            for (j in (i + 1) until items.size) {
                if (items[j] < items[lower]) {
                    lower = j
                }
            }
            items.swap(lower, i)
        }

        return items
    }
}
