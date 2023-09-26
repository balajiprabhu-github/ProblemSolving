package medium

fun main() {
    println(Solution1689().minPartitions("32"))
}

private class Solution1689 {
    fun minPartitions(n: String): Int {
        var result = 0

        for(c in n) {
            result = Math.max(result,c-'0')
        }

        return result
    }
}