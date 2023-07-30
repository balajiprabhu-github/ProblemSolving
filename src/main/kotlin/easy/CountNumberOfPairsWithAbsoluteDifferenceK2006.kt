package easy

fun main() {
    println(Solution2006().countKDifference(intArrayOf(1,2,2,1),1))
    println(Solution2006().countKDifference(intArrayOf(1,3),3))
    println(Solution2006().countKDifference(intArrayOf(3,2,1,5,4),2))
}

private class Solution2006 {
    fun countKDifference(nums: IntArray, k: Int): Int {
        var result = 0

        for (i in nums.indices) {
            for (j in i+1 until nums.size) {
                if (Math.abs(nums[i]-nums[j]) == k) {
                    result++
                }
            }
        }

        return result
    }
}