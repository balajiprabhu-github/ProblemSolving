package easy

fun main() {
    println(Solution219().containsNearbyDuplicate(intArrayOf(1,2,3,1),3))
}

private class Solution219 {
    fun containsNearbyDuplicate(nums: IntArray, k: Int): Boolean {
        val map = HashMap<Int, Int>()

        for (i in nums.indices) {
            val num = nums[i]

            if (map.containsKey(num) && i - map[num]!! <= k) {
                return true
            }

            map[num] = i
        }

        return false
    }
}