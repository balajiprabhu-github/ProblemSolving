package easy

import java.util.*

fun main() {
    Solution561().arrayPairSum(intArrayOf(1,4,3,2))
    Solution561().arrayPairSum(intArrayOf(6,2,6,5,1,2))
}

private class Solution561 {
    fun arrayPairSum(nums: IntArray): Int {
        Arrays.sort(nums)
        var result = 0

        for(i in nums.indices step 2){
            result += nums[i]
        }

        return result
    }
}