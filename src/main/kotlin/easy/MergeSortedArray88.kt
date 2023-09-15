package easy

fun main() {
    Solution88().merge(intArrayOf(1,2,3,0,0,0),6,intArrayOf(2,5,6),3)
}

private class Solution88 {
    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
        var p1 = m-1
        var p2 = n-1

        var i = m+n-1

        while(p2 >= 0 ){
            if(p1 >= 0 && nums1[p1] > nums2[p2]) {
                nums1[i--] = nums1[p1--]
            } else {
                nums1[i--] = nums2[p2--]
            }
        }
    }
}