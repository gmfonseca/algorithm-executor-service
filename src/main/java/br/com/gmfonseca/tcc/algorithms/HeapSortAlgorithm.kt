package br.com.gmfonseca.tcc.algorithms

/**
 * Created by Gabriel Fonseca on 31/01/2021.
 */
class HeapSortAlgorithm<T : Comparable<T>> : SortAlgorithm<T> {

    override fun sort(items: List<T>): List<T> {
        val mutableList = items.toMutableList()
        var size = items.size
        var i = size / 2
        var parent: Int
        var child: Int
        var temp: T

        while (true) {
            if (i > 0) {
                i--
                temp = mutableList[i]
            } else {
                size--
                if (size <= 0) {
                    return mutableList
                }
                temp = mutableList[size]
                mutableList[size] = mutableList.first()
            }

            parent = i
            child = ((i * 2) + 1)
            while (child < size) {
                if ((child + 1 < size) && mutableList[child + 1] > mutableList[child]) {
                    child++
                }

                if (mutableList[child] > temp) {
                    mutableList[parent] = mutableList[child]
                    parent = child
                    child = parent * 2 + 1
                } else {
                    break
                }
            }

            mutableList[parent] = temp
        }
    }
}
