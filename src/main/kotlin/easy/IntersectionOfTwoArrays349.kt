package easy

fun main() {
    println(Solution349().intersection(intArrayOf(1,2,2,1), intArrayOf(1)))
}

private class Solution349 {
    fun intersection(nums1: IntArray, nums2: IntArray): IntArray {
        val set1 = HashSet(nums1.asList())
        val resultSet = HashSet<Int>()

        for (num in nums2) {
            if (set1.contains(num)) {
                resultSet.add(num)
            }
        }

        val resultArray = IntArray(resultSet.size)
        var index = 0
        for (num in resultSet) {
            resultArray[index] = num
            index++
        }

        return resultArray
    }
}