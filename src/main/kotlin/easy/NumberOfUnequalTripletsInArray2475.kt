package easy

fun main() {
    println(Solution2475().unequalTriplets(intArrayOf(4,4,2,4,3)))
    println(Solution2475().unequalTriplets(intArrayOf(1,1,1,1,1)))
}

private class Solution2475 {
    fun unequalTriplets(nums: IntArray): Int {
        var result = 0

        for (i in 0 until nums.size-2) {

            val set = mutableSetOf<Int>()

            for (j in i until nums.size) {
               set.add(nums[j])
            }

            if (set.size == 3) {
                result++
            }
        }

        return result
    }

}