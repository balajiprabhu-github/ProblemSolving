package medium


fun main() {
    val array = Solution54().spiralOrder(arrayOf(intArrayOf(1, 2, 3,4), intArrayOf( 5, 6,7,8), intArrayOf(9,10,11,12)))

    println(array.toString())

}

private class Solution54 {
    fun spiralOrder(matrix: Array<IntArray>): List<Int> {
        val result = mutableListOf<Int>()
        var topRow = 0
        var bottomRow = matrix.size-1
        var leftCol = 0
        var rightCol =  matrix[0].size-1

        while (topRow <= bottomRow && leftCol <= rightCol) {

            for (i in topRow..rightCol) {
                result.add(matrix[topRow][i])
            }
            topRow++

            for (i in topRow..bottomRow) {
                result.add(matrix[i][rightCol])
            }

            rightCol--

            if (topRow <= bottomRow) {
                for (i in rightCol downTo leftCol) {
                    result.add(matrix[bottomRow][i])
                }
                bottomRow--
            }


            if (leftCol <= rightCol) {
                for (i in bottomRow downTo topRow) {
                    result.add(matrix[i][leftCol])
                }
                leftCol++
            }

        }

        return result
    }
}