package easy

fun main() {
    println(Solution121().maxProfit(intArrayOf(7,1,5,3,6,4)))
}

private class Solution121 {
    fun maxProfit(prices: IntArray): Int {
        var currentMin = Int.MAX_VALUE
        var profit = 0

        for(price in prices) {
            currentMin = Math.min(currentMin, price)
            profit = Math.max(profit,price-currentMin)
        }

        return profit
    }
}