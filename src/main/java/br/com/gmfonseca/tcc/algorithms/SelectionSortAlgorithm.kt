package br.com.gmfonseca.tcc.algorithms

/**
 * Created by Gabriel Fonseca on 31/01/2021.
 */
class SelectionSortAlgorithm<T : Comparable<T>> : SortAlgorithm<T> {

    override fun sort(items: List<T>): List<T> {
        val mutableList = items.toMutableList()

        for (i in mutableList.indices) {
            var lower = i
            for (j in (i + 1) until mutableList.size) {
                if (mutableList[j] < mutableList[lower]) {
                    lower = j
                }
            }
            mutableList.swap(lower, i)
        }

        return mutableList
    }
}
