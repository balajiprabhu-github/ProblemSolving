package easy

import java.util.*

fun main() {
    println(Solution1365().smallerNumbersThanCurrent(intArrayOf(8, 1, 2, 2, 3)).contentToString())
}

private class Solution1365 {

    //Input: num = [8,1,2,2,3]
    //Output: [4,0,1,1,3]
    fun smallerNumbersThanCurrent(nums: IntArray): IntArray {

        val list = mutableListOf<Int>()
        for (i in nums) {
            var temp = 0
            for (j in nums) {
                if (i > j) {
                    temp++
                }
            }
            list.add(temp)
        }

        return list.toIntArray()
    }
}