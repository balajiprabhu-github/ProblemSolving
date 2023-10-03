package easy

fun main() {
    println(Solution1512().numIdenticalPairs(intArrayOf(1,2,3,1,1,3)))
    println(Solution1512().numIdenticalPairs(intArrayOf(1,1,1,1)))
    println(Solution1512().numIdenticalPairs(intArrayOf(1,2,3)))
}

private class Solution1512 {
    fun numIdenticalPairs(nums: IntArray): Int {
        var result = 0

        for (i in nums.indices) {
            for (j in nums.indices) {
                if (i < j && nums[i] == nums[j]) {
                    result++
                }
            }
        }
        return result
    }

    fun numIdenticalPairsII(nums: IntArray): Int {
        var result = 0

        val numsTimes = IntArray(101)

        for(num in nums) {
            numsTimes[num] += 1
        }

        for(i in numsTimes) {
            if(i > 0) {
                result += (i * (i-1)/2)
            }
        }

        return result
    }
}