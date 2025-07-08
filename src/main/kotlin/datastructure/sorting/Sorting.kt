package datastructure.sorting

fun main() {
    val array = arrayOf(9,5,1,4,8,2,7,10,3)
    MergeSort().sort(array)
    println(array.contentToString())
}

private fun swap(array: Array<Int>, indexA: Int, indexB: Int) {
    val temp = array[indexA]
    array[indexA] = array[indexB]
    array[indexB] = temp
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
}

class BubbleSort {
    fun sort(array: Array<Int>) {
        for ( i in array.size-1 downTo 0) {
            for(j in 0 until i) {
                if (array[j] > array[j+1]) {
                    swap(array,j,j+1)
                }
            }
        }
    }
}

class InsertionSort {
    fun sort(array: Array<Int>) {
        for(i in array.indices) {
            var j = i
            while( j > 0 && array[j-1] > array[j]) {
                swap(array,j-1,j)
                j--
            }
        }
    }
}

class MergeSort {
    fun sort(array: Array<Int>) {
        divideAndMerge(array,0,array.size-1)
    }

    private fun divideAndMerge(array: Array<Int>, low: Int, high: Int) {
        if(low >= high) return
        val mid = (low + high) / 2
        divideAndMerge(array,low, mid)
        divideAndMerge(array,mid+1, high)
        merge(array,low, mid, high)
    }

    private fun merge(array: Array<Int>, low: Int, mid:Int, high: Int) {
        var left = low
        var right = mid+1
        val temp = mutableListOf<Int>()

        while(left <= mid && right <= high) {
            if(array[left] <= array[right]) {
                temp.add(array[left])
                left++
            } else {
                temp.add(array[right])
                right++
            }
        }

        while(left <= mid) {
            temp.add(array[left])
            left++
        }

        while(right <= high) {
            temp.add(array[right])
            right++
        }

        for (i in temp.indices) {
            array[low + i] = temp[i]
        }
    }
}

