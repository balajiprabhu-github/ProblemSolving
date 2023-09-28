package easy

fun main() {
    println(Solution905().sortArrayByParity(intArrayOf(1,2,3,4)))
}

private class Solution905 {
    fun sortArrayByParity(nums: IntArray): IntArray {
        var start = 0
        var end = nums.size-1

        while(start < end) {
            if(nums[start] % 2 != 0 && nums[end] % 2 == 0) {
                val temp = nums[start]
                nums[start] = nums[end]
                nums[end] = temp
                start++
                end--
            } else if(nums[start] % 2 == 0 && nums[end] % 2 == 0) {
                start++
            } else if(nums[start] % 2 != 0 && nums[end] % 2 != 0) {
                end--
            } else {
                start++
                end--
            }
        }

        return nums
    }
}