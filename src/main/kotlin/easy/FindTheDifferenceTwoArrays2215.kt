package easy

fun main() {
    println(Solution2215().findDifference(intArrayOf(1,2,3), intArrayOf(2,4,6)))
}

private class Solution2215 {
    fun findDifference(nums1: IntArray, nums2: IntArray): List<List<Int>> {

        val result = mutableListOf<List<Int>>()
        val listOne = mutableSetOf<Int>()
        val listTwo = mutableSetOf<Int>()


        nums1.forEach {
            if (!nums2.toSet().contains(it)) {
                listOne.add(it)
            }
        }

        nums2.forEach {
            if (!nums1.toSet().contains(it)) {
                listTwo.add(it)
            }
        }

        result.add(listOne.toList())
        result.add(listTwo.toList())

        return result.toList()
    }
}