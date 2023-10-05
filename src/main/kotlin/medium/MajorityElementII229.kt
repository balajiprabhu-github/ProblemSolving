package medium

import kotlin.math.ceil

fun main() {
    println(Solution229().majorityElement(intArrayOf(3,2,3)))
}

private class Solution229 {
    fun majorityElement(nums: IntArray): List<Int> {
        val result = mutableListOf<Int>()

        val map = nums.toList().groupingBy { it }.eachCount()

        val condition = (nums.size / 3).toDouble()

        for(key in map.keys) {
            val count = map.getOrDefault(key,0)
            if(count > ceil(condition)) {
                result.add(key)
            }
        }

        return result
    }
}