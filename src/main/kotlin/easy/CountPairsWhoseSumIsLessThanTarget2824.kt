package easy

fun main() {
    Solution2824().countPairs(listOf(-6,2,5,-2,-7,-1,3),2)
}

private class Solution2824 {
    fun countPairs(nums: List<Int>, target: Int): Int {
        var result = 0

        for (i in nums.indices) {
            for (j in i+1 until nums.size) {
                if (nums[i]+nums[j] < target) {
                    result++
                }
            }
        }

        return result
    }
}