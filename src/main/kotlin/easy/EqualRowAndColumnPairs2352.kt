package easy

import java.lang.StringBuilder

fun main() {
    println(Solution2352().equalPairs(arrayOf(intArrayOf(3,2,1), intArrayOf(1,7,6), intArrayOf(2,7,7))))
}

private class Solution2352 {
    fun equalPairs(grid: Array<IntArray>): Int {
        // brute force
        /*var result = 0
        val n = grid.size

        for (r in 0 until n){
            val row = grid[r]
            for (i in 0 until n){
                var count = 0
                for (j in 0 until n){
                    val rc = row[j]
                    val cr = grid[j][i]
                    if (rc == cr){
                        count++
                    }
                }

                if (count == n){
                    result++
                }
            }
        }

        return result*/

        var result = 0
        val rowHash = mutableMapOf<String,Int>()
        val colHash = mutableMapOf<String,Int>()
        val n = grid.size

        for (i in 0 until n) {
            val sb = StringBuilder("")
            for (j in 0 until n){
                sb.append("${grid[i][j]}_")
            }
            rowHash[sb.toString()] = rowHash.getOrDefault(sb.toString(),0)+1
        }

        for (i in 0 until n) {
            val sb = StringBuilder("")
            for (j in 0 until n){
                sb.append("${grid[j][i]}_")
            }
            colHash[sb.toString()] = colHash.getOrDefault(sb.toString(),0)+1
        }

        for (row in rowHash) {
            val rowItem = row.key

            if(colHash.contains(rowItem)) {
                result = colHash.getValue(rowItem)*rowHash.getValue(rowItem)
            }
        }

        return result
    }
}