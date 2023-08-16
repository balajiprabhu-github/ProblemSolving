package easy

fun main() {
    println(Solution2367().arithmeticTriplets(intArrayOf(0,1,4,6,7,10),3))
}

private class Solution2367 {
    fun arithmeticTriplets(nums: IntArray, diff: Int): Int {

        val set = nums.toSet()
        var result = 0
        for(i in nums) {
            if(set.contains(i-diff) && set.contains(i-(2*diff))) {
                result++
            }
        }

        return result
    }
}