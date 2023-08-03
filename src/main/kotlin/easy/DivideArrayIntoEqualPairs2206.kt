package easy

fun main() {
    println(Solution2206().divideArray(intArrayOf(3,2,3,2,2,2)))
}

private class Solution2206 {
    fun divideArray(nums: IntArray): Boolean {
        nums.groupBy{it}.forEach {
            if (it.value.size % 2 != 0) {
                return false
            }
        }
        return true
    }
}