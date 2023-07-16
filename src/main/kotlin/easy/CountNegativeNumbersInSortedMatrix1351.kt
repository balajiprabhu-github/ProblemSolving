package easy

fun main() {
    println(Solution1351().countNegatives(arrayOf(intArrayOf(-1, -1, 0), intArrayOf(-1, 0, -1), intArrayOf(0, 0, 0))))
}

private class Solution1351 {
    fun countNegatives(grid: Array<IntArray>): Int {
        var result = 0

        for(row in grid.indices) {
            for(col in grid[row].indices) {
                if(grid[row][col] < 0) {
                    result++
                }
            }
        }

        return result
    }
}