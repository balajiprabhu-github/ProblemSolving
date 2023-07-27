package easy

fun main() {
    //[-3,-1,1,3,5]
    //[-2,-1,0,2,3]
    println(Solution2670().distinctDifferenceArray(intArrayOf(1,2,3,4,5)).contentToString())
    println(Solution2670().distinctDifferenceArray(intArrayOf(3,2,3,4,2)).contentToString())
}

private class Solution2670 {
    fun distinctDifferenceArray(nums: IntArray): IntArray {
        val result = IntArray(nums.size)

        for (i in nums.indices) {
            val prefix = distinctCount(nums,0,i)
            val suffix = distinctCount(nums,i+1,nums.size-1)
            result[i] = prefix - suffix
        }

        return result
    }

    fun distinctCount(nums: IntArray, startIndex:Int, endIndex: Int) : Int {

        val set = mutableSetOf<Int>()

        for (i in startIndex..endIndex) {
            set.add(nums[i])
        }

        return set.size
    }

}