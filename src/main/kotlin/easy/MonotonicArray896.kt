package easy

fun main() {
    println(Solution896().isMonotonic(intArrayOf(1,2,2,3)))
}

private class Solution896 {
    fun isMonotonic(nums: IntArray): Boolean {
        val size = nums.size
        if(size == 1) {
            return true
        }

        val isIncreasing = nums[0] <= nums[size-1]
        for(i in 0 until nums.size-1) {
            if(isIncreasing) {
                if(nums[i] > nums[i+1]) {
                    return false
                }
            } else{
                if(nums[i] < nums[i+1]) {
                    return false
                }
            }
        }

        return true
    }
}