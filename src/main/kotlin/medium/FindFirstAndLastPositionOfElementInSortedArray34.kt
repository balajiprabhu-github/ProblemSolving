package medium

fun main() {
    println(Solution34().searchRange(intArrayOf(5,7,7,8,8,10),8).contentToString())
    println(Solution34().searchRange(intArrayOf(5,7,7,8,8,10),6).contentToString())
    println(Solution34().searchRange(intArrayOf(),0).contentToString())
}

private class Solution34 {
    fun searchRange(nums: IntArray, target: Int): IntArray {

        var start = 0
        var end = nums.size-1
        val result = IntArray(2) {-1}

        while(start <= end) {
            val mid = start+((end-start))/2
            if(nums[mid] == target) {
                result[0] = mid
                end = mid - 1
            } else if (nums[mid] < target) {
                start = mid+1
            } else {
                end = mid-1
            }
        }

        if (result[0] == -1) {
            return result
        }

        start = 0
        end = nums.size-1

        while(start <= end) {
            val mid = start+((end-start))/2
            if(nums[mid] == target) {
                result[1] = mid
                start = mid + 1
            } else if (nums[mid] < target) {
                start = mid+1
            } else {
                end = mid-1
            }
        }

        return result
    }
}