package easy

fun main() {
    println(Solution1173().leftRightDifference(intArrayOf(10,4,8,3)).toList().toString())
    println(Solution1173().leftRightDifference(intArrayOf(1)).toList().toString())
}

private class Solution1173 {
    fun leftRightDifference(nums: IntArray): IntArray {
        val answer = IntArray(nums.size)
        val leftSum = IntArray(nums.size)
        val rightSum = IntArray(nums.size)

        var leftSumNum = 0
        var rightSumNum = 0

        for (i in 1 until nums.size) {
            leftSumNum += nums[i-1]
            leftSum[i] = leftSumNum
        }

        for (i in nums.size-2 downTo   0) {
            rightSumNum += nums[i+1]
            rightSum[i] = rightSumNum
        }

        for (i in answer.indices) {
            var temp: Int = leftSum[i] - rightSum[i]
            if (temp < 0) {
                temp*=-1
            }
            answer[i] = temp
        }

        return answer

    }
}