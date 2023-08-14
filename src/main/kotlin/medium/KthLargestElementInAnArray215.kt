package medium

import java.util.*

fun main() {
    println(Solution215().findKthLargest(intArrayOf(3,2,1,5,6,4),2))
    println(Solution215().findKthLargest(intArrayOf(3,2,3,1,2,4,5,5,6),4))
    println(Solution215().findKthLargest(intArrayOf(4,2,9,7,5,6,7,1,3),4))
}

private class Solution215 {
    fun findKthLargest(nums: IntArray, k: Int): Int {

        val minHeap = PriorityQueue<Int>()

        for (num in nums) {
            minHeap.offer(num)
            if (minHeap.size > k) {
                minHeap.poll()
            }
        }

        return minHeap.poll()
    }
}