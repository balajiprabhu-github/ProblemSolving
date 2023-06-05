package easy

fun main() {
    println(Solution217().containsDuplicate(intArrayOf(1,2,3,1)))
    println(Solution217().containsDuplicate(intArrayOf(1,2,3,4)))
}

private class Solution217 {
    fun containsDuplicate(nums: IntArray): Boolean {
        return nums.size != nums.toSet().size
    }
}