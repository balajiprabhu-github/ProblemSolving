package medium

fun main() {
    println(Solution137().singleNumber(intArrayOf(2,2,3,2)))
    println(Solution137().singleNumber(intArrayOf(0,1,0,1,0,1,99)))
}

private class Solution137 {
    fun singleNumber(nums: IntArray): Int {

        val map = mutableMapOf<Int,Int>()

        for (num in nums) {
            val frequency = map.getOrDefault(num,0)+1
            map[num] = frequency
        }

        return map.filter { it.value == 1 }.keys.first()

    }
}