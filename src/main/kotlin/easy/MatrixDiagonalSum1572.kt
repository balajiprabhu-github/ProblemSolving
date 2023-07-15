package easy

fun main() {
    Solution1572().diagonalSum(arrayOf(intArrayOf(1, 2, 3), intArrayOf(4, 5, 6), intArrayOf(7, 8, 9)))
}

private class Solution1572 {
    fun diagonalSum(mat: Array<IntArray>): Int {

        var result = 0
        var counter = mat.size-1

        for(i in mat.indices) {
            result += if(i == counter) {
                mat[i][counter--]
            } else {
                mat[i][i] + mat[i][counter--]
            }
        }

        return result
    }
}