package easy

import medium.Solution2807

fun main() {
    println(Solution35().searchInsert(intArrayOf(1,2,3,4,6),5))
}

private class Solution35 {
    fun searchInsert(nums: IntArray, target: Int): Int {
        var left = 0
        var right = nums.size - 1

        while (left <= right) {
            val mid = left + (right - left) / 2

            if (nums[mid] == target) {
                return mid
            } else if (nums[mid] < target) {
                left = mid + 1
            } else {
                right = mid - 1
            }
        }

        return left
    }
}