package easy

fun main() {
    println(Solution1920().buildArray(intArrayOf(0,2,1,5,3,4)).toList().toString())
}

private class Solution1920 {
    fun buildArray(nums: IntArray): IntArray {
        val ans = IntArray(nums.size)
        for (i in nums.indices){
            ans[i] = nums[nums[i]]
        }
        return ans
    }
}