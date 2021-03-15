package br.com.gmfonseca.tcc.algorithms

/**
 * Created by Gabriel Fonseca on 31/01/2021.
 */
class HeapSortAlgorithm<T : Comparable<T>> : SortAlgorithm<T> {

    override fun sort(items: MutableList<T>): List<T> {
        var size = items.size
        var i = size / 2
        var parent: Int
        var child: Int
        var temp: T

        while (true) {
            if (i > 0) {
                i--
                temp = items[i]
            } else {
                size--
                if (size <= 0) {
                    return items
                }
                temp = items[size]
                items[size] = items.first()
            }

            parent = i
            child = ((i * 2) + 1)
            while (child < size) {
                if ((child + 1 < size) && items[child + 1] > items[child]) {
                    child++
                }

                if (items[child] > temp) {
                    items[parent] = items[child]
                    parent = child
                    child = parent * 2 + 1
                } else {
                    break
                }
            }

            items[parent] = temp
        }
    }
}
