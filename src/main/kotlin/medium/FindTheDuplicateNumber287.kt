package medium

fun main() {
    println(Solution287().findDuplicate(intArrayOf(1,2,2,3,4)))
}

private class Solution287 {
    fun findDuplicate(nums: IntArray): Int {
        // Phase 1: Detect if there's a cycle in the array
        var slow = nums[0]
        var fast = nums[0]

        do {
            slow = nums[slow]
            fast = nums[nums[fast]]
        } while (slow != fast)

        // Phase 2: Find the entrance to the cycle
        slow = nums[0]
        while (slow != fast) {
            slow = nums[slow]
            fast = nums[fast]
        }

        return slow
    }
}