package easy

fun main() {
    println(Solution1672().maximumWealth(arrayOf(intArrayOf(1, 2, 3), intArrayOf(4, 5, 6), intArrayOf(7, 8, 9))))
}

private class Solution1672 {
    fun maximumWealth(accounts: Array<IntArray>): Int {
        var result = 0

        for (i in accounts) {
            var temp = 0
            for (j in i) {
                temp += j
            }

            if (temp > result) {
                result = temp
            }
        }
        return result
    }
}