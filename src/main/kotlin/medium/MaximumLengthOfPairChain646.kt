package medium

fun main() {
    println(Solution646().findLongestChain(arrayOf(intArrayOf(1,2), intArrayOf(2,3), intArrayOf(3,4))))
    println()
    println(Solution646().findLongestChain(arrayOf(intArrayOf(1,2), intArrayOf(7,8), intArrayOf(4,5))))
    println()
    println(Solution646().findLongestChain(arrayOf(intArrayOf(3,4), intArrayOf(2,3), intArrayOf(1,2))))
}

private class Solution646 {
    fun findLongestChain(pairs: Array<IntArray>): Int {

        pairs.sortBy { it[1] }

        var longestChain = 0
        var endOfChain = Int.MIN_VALUE

        for (pair in pairs) {
            if (pair[0] > endOfChain) {
                longestChain++
                endOfChain = pair[1]
            }
        }

        return longestChain

    }
}