package easy

fun main() {
    println(Solution977().sortedSquares(intArrayOf(-4,-1,0,3,10)))
}

private class Solution977 {
    fun sortedSquares(nums: IntArray): IntArray {

        var start = 0
        var end = nums.size-1
        val result = IntArray(nums.size)
        var i = end

        while(start <= end) {
            if(Math.abs(nums[start]) > Math.abs(nums[end])) {
                result[i--] = nums[start] * nums[start]
                start++
            } else {
                result[i--] = nums[end] * nums[end]
                end--
            }
        }

        return result
    }
}