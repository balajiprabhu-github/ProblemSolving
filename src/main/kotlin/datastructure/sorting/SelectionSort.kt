package datastructure.sorting

fun main() {
    val array = arrayOf(9,5,1,4,8,2,7,10,3)
    SelectionSort().sort(array)
    println(array.contentToString())
}

class SelectionSort {
    fun sort(array: Array<Int>) {
        for (i in 0 until array.size - 1) {
            var min = i
            for (j in i until array.size) {
                if (array[j] < array[min]) {
                    min = j
                }
            }
            swap(array, i, min)
        }
    }

    private fun swap(array: Array<Int>, indexA: Int, indexB: Int) {
        val temp = array[indexA]
        array[indexA] = array[indexB]
        array[indexB] = temp
    }
}


