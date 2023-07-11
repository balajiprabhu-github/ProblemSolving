package easy

import java.util.*

fun main() {
    val array = Solution832().flipAndInvertImage(arrayOf(intArrayOf(1, 1, 0), intArrayOf(1, 0, 1), intArrayOf(0, 0, 0)))
    for (i in array.indices) {
        println(array[i].contentToString())
    }

}

private class Solution832 {
    fun flipAndInvertImage(image: Array<IntArray>): Array<IntArray> {
        val result : Array<IntArray> = Array(image.size){IntArray(image.size)}

        for (i in image.indices) {
            var start = 0
            var end = image.size-1
            val array = image[i]

            while (start <= end) {
                var first = array[start]
                var last = array[end]

                first = if (first == 1) { 0 } else { 1 }
                last = if (last == 1) { 0 } else { 1 }

                array[start] = last
                array[end] = first
                start++
                end--
            }

            result[i] = array
        }

        return result
    }
}