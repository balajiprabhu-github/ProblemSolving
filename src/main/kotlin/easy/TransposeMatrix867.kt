package easy

fun main() {
    val array = Solution867().transpose(arrayOf(intArrayOf(1, 2, 3), intArrayOf(4, 5, 6), intArrayOf(7, 8, 9)))
    val array1 = Solution867().transpose(arrayOf(intArrayOf(1, 2, 3), intArrayOf(4, 5, 6)))
    for (i in array.indices) {
        println(array[i].contentToString())
    }

    for (i in array1.indices) {
        println(array1[i].contentToString())
    }
}

private class Solution867 {
    fun transpose(matrix: Array<IntArray>): Array<IntArray> {
        val result : Array<IntArray> = Array(matrix[0].size){IntArray(matrix.size)}
        for(i in matrix.indices) {
            for(j in 0 until matrix[i].size) {
                result[j][i] = matrix[i][j]

            }
        }
        return result
    }
}