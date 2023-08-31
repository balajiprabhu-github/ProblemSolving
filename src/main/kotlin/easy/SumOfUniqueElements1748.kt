package easy

fun main() {
    println(Solution1748().sumOfUnique(intArrayOf(1,2,3,2)))
    println(Solution1748().sumOfUnique(intArrayOf(1,1,1,1,1)))
    println(Solution1748().sumOfUnique(intArrayOf(1,2,3,4,5)))
    println(Solution1748().sumOfUnique(intArrayOf(1)))
}

private class Solution1748 {
    fun sumOfUnique(nums: IntArray): Int {
        return  nums.toList().groupingBy { it }.eachCount().filter { it.value == 1 }.keys.sum()
    }
}