package medium

fun main() {
    println(Solution260().singleNumber(intArrayOf(1,2,1,3,2,5)))
}

private class Solution260 {
    fun singleNumber(nums: IntArray): IntArray {
        var xorResult = 0
        for (num in nums) {
            xorResult = xorResult xor num
        }

        // Find the rightmost set bit in the XOR result
        var rightmostSetBit = 1
        while ((xorResult and rightmostSetBit) == 0) {
            rightmostSetBit = rightmostSetBit shl 1
        }

        // Initialize two variables to store the two single numbers
        var num1 = 0
        var num2 = 0

        // Partition the numbers into two groups based on the rightmost set bit
        for (num in nums) {
            if ((num and rightmostSetBit) == 0) {
                num1 = num1 xor num
            } else {
                num2 = num2 xor num
            }
        }

        return intArrayOf(num1, num2)
    }
}