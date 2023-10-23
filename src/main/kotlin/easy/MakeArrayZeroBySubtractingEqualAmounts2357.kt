package easy

fun main() {
    println(Solution2357().minimumOperations(intArrayOf(1,5,0,3,5)))
}

private class Solution2357 {
    fun minimumOperations(nums: IntArray): Int {

        val set = mutableSetOf<Int>()

        for(num in nums) {
            if(num != 0) {
                set.add(num)
            }
        }

        return set.size

    }
}