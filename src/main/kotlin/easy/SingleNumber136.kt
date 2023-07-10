package easy

import java.util.*

fun main() {
    println(Solution136().singleNumber(intArrayOf(2,2,1)))
    println(Solution136().singleNumber(intArrayOf(4,1,2,1,2)))
    println(Solution136().singleNumber(intArrayOf(1)))
}

private class Solution136 {
    fun singleNumber(nums: IntArray): Int {

        if (nums.size == 1) {
            return nums[0]
        }

        Arrays.sort(nums)

        val stack = Stack<Int>()

        for (num in nums) {
            if (!stack.contains(num)) {
                stack.push(num)
            } else {
                stack.pop()
            }
        }


        return stack.peek()
    }
}