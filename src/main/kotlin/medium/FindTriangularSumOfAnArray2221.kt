package medium

fun main() {
    println(Solution2221().triangularSum(intArrayOf(1,2,3,4,5)))
}

private class Solution2221 {
    fun triangularSum(nums: IntArray): Int {
        var numsArray = nums

        for(i in numsArray.size-1 downTo 1) {
            val newNums = IntArray(i)
            for(j in 0 until i) {
                newNums[j] = (numsArray[j] + numsArray[j+1]) % 10
            }
            numsArray = newNums
        }


        return numsArray[0]

    }
}