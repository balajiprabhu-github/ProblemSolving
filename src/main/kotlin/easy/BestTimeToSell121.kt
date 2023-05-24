package easy

fun main() {
    println(Solution121().maxProfit(intArrayOf(7,1,5,3,6,4)))
}

class Solution121 {
    fun maxProfit(prices: IntArray): Int {
        var minValue = Int.MAX_VALUE
        var profit = 0

        for((value) in prices.withIndex()) {
            if(value < minValue) {
                minValue = value
            } else if(value - minValue > profit) {
                profit = value - minValue
            }
        }

        return profit
    }
}