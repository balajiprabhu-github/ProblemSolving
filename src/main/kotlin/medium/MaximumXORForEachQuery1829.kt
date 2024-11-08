package medium

class Solution1829 {
    fun getMaximumXor(nums: IntArray, maximumBit: Int): IntArray {

        val n = nums.size
        val maxK = (1 shl maximumBit) - 1
        var totalXor = nums.reduce { acc, num -> acc xor num }
        val answer = IntArray(n)

        for (i in n - 1 downTo 0) {
            answer[n - 1 - i] = totalXor xor maxK
            totalXor = totalXor xor nums[i]
        }

        return answer
    }
}