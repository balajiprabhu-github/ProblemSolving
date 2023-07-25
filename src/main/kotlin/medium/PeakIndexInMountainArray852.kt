package medium

fun main() {
    println(Solution852().peakIndexInMountainArray(intArrayOf(0,10,5,2)))
}

private class Solution852 {
    fun peakIndexInMountainArray(arr: IntArray): Int {
        for (i in 1 until arr.size) {
            if (arr[i] < arr[i-1]) {
                return i-1
            }
        }
        return 0
    }
}