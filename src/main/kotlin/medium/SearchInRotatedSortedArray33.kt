package medium

fun main() {
    println(Solution33().search(intArrayOf(),1))
    println(Solution33().search(intArrayOf(),1))
    println(Solution33().search(intArrayOf(),1))
}

private class Solution33 {
    fun search(nums: IntArray, target: Int): Int {

        val n = nums.size
        var low = 0
        var high: Int = n - 1
        while (low <= high) {
            val mid = (low + high) / 2

            // if mid points to the target
            if (nums[mid] == target) return mid

            // if left part is sorted
            if (nums[low] <= nums[mid]) {
                if (nums[low] <= target && target <= nums[mid]) {
                    // element exists
                    high = mid - 1
                } else {
                    // element does not exist
                    low = mid + 1
                }
            } else { // if right part is sorted
                if (nums[mid] <= target && target <= nums[high]) {
                    // element exists
                    low = mid + 1
                } else {
                    // element does not exist
                    high = mid - 1
                }
            }
        }
        return -1

//        var start = 0
//        var end = nums.size-1
//
//        while (start<=end) {
//
//            val mid = start+(end - start)/2
//
//            if(nums[mid] == target) return mid
//
//            if (nums[start] <= nums[mid]) {
//
//               if (nums[start] <= target && target <= nums[end]) {
//                   end = mid-1
//               } else {
//                   start = mid+1
//               }
//
//            } else {
//
//                if (nums[mid] <= target && target <= nums[end]) {
//                    start = mid+1
//                } else {
//                    end = mid-1
//                }
//
//            }
//
//        }
//
//        return -1
    }
}