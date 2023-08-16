package hard

import kotlin.math.max

fun main() {
    println(Solution239().maxSlidingWindow(intArrayOf(1,3,-1,-3,5,3,6,7),3).contentToString())
}

private class Solution239 {
    fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
        val result = mutableListOf<Int>()
        for (i in 0.. nums.size-k) {
            var max = Int.MIN_VALUE
            for (j in i until i+k) {
                max = max(nums[j],max)
            }
            result.add(max)
        }

        return result.toIntArray()
    }
}