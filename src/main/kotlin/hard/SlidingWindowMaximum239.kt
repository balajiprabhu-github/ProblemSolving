package hard

import java.util.ArrayDeque

fun main() {
    println(Solution239().maxSlidingWindow(intArrayOf(1,3,-1,-3,5,3,6,7),3).contentToString())
}

private class Solution239 {
    fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
        val result = mutableListOf<Int>()
        val deque = ArrayDeque<Int>()

        for (i in nums.indices) {
            // Remove elements outside the window from the front of the deque
            while (!deque.isEmpty() && deque.peek() < i - k + 1) {
                deque.poll()
            }

            // Remove elements that are smaller than the current element from the rear of the deque
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast()
            }

            // Add the current index to the rear of the deque
            deque.offer(i)

            // If the window size is greater than or equal to k, add the maximum element to the result
            if (i >= k - 1) {
                result.add(nums[deque.peek()])
            }
        }

        return result.toIntArray()
    }
}