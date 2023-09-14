package medium

fun main() {
    println(Solution122().maxProfit(intArrayOf(7,1,5,3,6,4)))
}

private class Solution122 {
    fun maxProfit(prices: IntArray): Int {
        var profit = 0

        for(i in 1 until prices.size) {
            if(prices[i] > prices[i-1]) {
                profit += prices[i] - prices[i-1]
            }
        }

        return profit
    }
}