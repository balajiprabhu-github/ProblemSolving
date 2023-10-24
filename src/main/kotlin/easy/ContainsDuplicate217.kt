package easy

fun main() {
    println(Solution217().containsDuplicate(intArrayOf(1,2,3,1)))
    println(Solution217().containsDuplicate(intArrayOf(1,2,3,4)))
}

private class Solution217 {
    fun containsDuplicate(nums: IntArray): Boolean {
        return nums.size != nums.toSet().size
    }

    fun containsDuplicate1(nums: IntArray): Boolean {
        val set = mutableSetOf<Int>()

        for(num in nums) {
            if(set.contains(num)) {
                return true
            } else {
                set.add(num)
            }
        }

        return false
    }
}