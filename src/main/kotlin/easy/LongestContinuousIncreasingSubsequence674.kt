package easy

fun main() {
    println(Solution674().findLengthOfLCIS(intArrayOf(1,3,5,4,7)))
    println(Solution674().findLengthOfLCIS(intArrayOf(2,2,2,2,2)))
}

private class Solution674 {
    fun findLengthOfLCIS(nums: IntArray): Int {

        var result = 1
        var prevMax = 1

        for(i in 1 until nums.size) {
            if(nums[i] > nums[i-1]) {
                result++
            } else {
                result = 1
            }
            prevMax = Math.max(result,prevMax)
        }

        return prevMax
    }
}