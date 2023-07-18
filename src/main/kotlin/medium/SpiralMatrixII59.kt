package medium

fun main() {
    val n = 5 // Change the value of n to generate a different size spiral matrix
    val spiralMatrix = Solution59().generateMatrix(n)

    // Print the spiral matrix
    for (row in spiralMatrix) {
        for (element in row) {
            print("$element\t")
        }
        println()
    }
}

private class Solution59 {
    fun generateMatrix(n: Int): Array<IntArray> {

        val result : Array<IntArray> = Array(n){IntArray(n)}

        var topRow = 0
        var bottomRow = n-1
        var leftCol = 0
        var rightCol = n-1
        var counter = 1

        while (counter <= n*n) {

            for (i in topRow..rightCol) {
                result[topRow][i] = counter++
            }
            topRow++

            for (i in topRow..bottomRow) {
                result[i][rightCol] = counter++
            }
            rightCol--

            for (i in rightCol downTo leftCol) {
                result[bottomRow][i] = counter++
            }

            bottomRow--

            for (i in bottomRow downTo  topRow) {
                result[i][leftCol] = counter++
            }

            leftCol++
        }

        return result
    }
}