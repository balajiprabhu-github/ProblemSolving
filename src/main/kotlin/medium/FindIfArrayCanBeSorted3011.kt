package medium

class Solution3011 {
    fun canSortArray(nums: IntArray): Boolean {
        var prevMax = 0
        var currMax = nums[0]
        var currMin = nums[0]
        var currSetBits = nums[0].countOneBits()

        for(num in nums) {
            if(currSetBits == num.countOneBits()) {
                currMax = Math.max(currMax,num)
                currMin = Math.min(currMin,num)
            } else {
                if(prevMax > currMin) {
                    return false
                }
                prevMax = currMax
                currSetBits = num.countOneBits()
                currMax = num
                currMin = num
            }
        }

        return currMin > prevMax
    }
}