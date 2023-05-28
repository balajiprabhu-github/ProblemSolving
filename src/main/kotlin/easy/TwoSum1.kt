package easy

fun main() {
    println(Solution1().twoSum(intArrayOf(2,7,11,15),9))
}

private class Solution1 {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val res = IntArray(2)
        val map: MutableMap<Int, Int> = HashMap()
        for (i in nums.indices) {
            if (map.containsKey(target - nums[i])) {
                res[1] = i
                res[0] = map[target - nums[i]]!!
                return res
            }
            map[nums[i]] = i
        }
        return res
    }
}

