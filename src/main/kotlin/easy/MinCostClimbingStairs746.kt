package easy

fun main() {
    println(Solution746().minCostClimbingStairs(intArrayOf(1,100,1,1,1,100,1,1,100,1)))
}

private class Solution746 {
    fun minCostClimbingStairs(cost: IntArray): Int {
        for (i in cost.size-2 downTo 0) {
            if(i == cost.size-2) {
                cost[i] = Math.min(cost[i], cost[i]+cost[i + 1])
            } else {
                cost[i] = Math.min((cost[i]+cost[i+1]),cost[i]+cost[i+2])
            }

        }

        return Math.min(cost[0],cost[1])
    }
}