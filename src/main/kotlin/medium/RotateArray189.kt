package medium

fun main() {
    Solution189().rotate(intArrayOf(1,2,3,4,5,6,7),3)
}

private class Solution189 {
    fun rotate(nums: IntArray, k1: Int): Unit {

        val k = if(k1 <= nums.size) k1 else k1%nums.size

        // reverse nums
        var start = 0
        var end = nums.size-1

        while(start<end){
            val left = nums[start]
            val right = nums[end]
            nums[start] = right
            nums[end] = left
            start++
            end--
        }

        // reverse 0 to k
        start = 0
        end = k-1

        while(start<end){
            val left = nums[start]
            val right = nums[end]
            nums[start] = right
            nums[end] = left
            start++
            end--
        }

        start = k
        end = nums.size-1

        while(start<end){
            val left = nums[start]
            val right = nums[end]
            nums[start] = right
            nums[end] = left
            start++
            end--
        }

        println(nums.contentToString())
    }
}