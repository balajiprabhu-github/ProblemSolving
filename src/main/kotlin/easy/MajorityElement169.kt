package easy

fun main() {
    Solution169().majorityElement(intArrayOf(2,2,1,1,1,2,2))
}

private class Solution169 {
    fun majorityElement(nums: IntArray): Int {
        var count = 0
        var majorityElement = 0
        nums.forEach{
            if(count == 0) majorityElement = it
            count += if(it == majorityElement) 1 else -1
        }
        return majorityElement
    }
}