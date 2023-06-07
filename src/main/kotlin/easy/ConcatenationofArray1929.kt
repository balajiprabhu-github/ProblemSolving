package easy

fun main(){
    println(Solution1929().getConcatenation(intArrayOf(1,2,1)).toList().toString())
}

private class Solution1929 {

    fun getConcatenation(nums: IntArray): IntArray {
        val ans = IntArray(nums.size*2)
        var secondPointer = 0
        for (i in ans.indices) {
            if (i >= nums.size) {
                ans[i] = nums[secondPointer++]
            } else {
                ans[i] = nums[i]
            }
        }
        return ans
    }
}