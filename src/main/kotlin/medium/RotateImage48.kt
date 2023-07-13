package medium


fun main() {
    Solution48().rotate(arrayOf(intArrayOf(1, 2, 3), intArrayOf(4, 5, 6), intArrayOf(7, 8, 9)))
}

private class Solution48 {
    fun rotate(matrix: Array<IntArray>): Unit {

        for(i in matrix.indices) {
            for(j in i until matrix[i].size) {
                val temp: Int = matrix[j][i]
                matrix[j][i] = matrix[i][j]
                matrix[i][j] = temp
            }
        }

        for (i in matrix.indices) {

            var start = 0
            var end = matrix[i].size-1

            while (start <= end){
                val first = matrix[i][start]
                val last = matrix[i][end]
                matrix[i][start] = last
                matrix[i][end] = first
                start++
                end--
            }
        }
    }
}