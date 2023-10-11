package easy

fun main() {
    println(Solution2404().mostFrequentEven(intArrayOf(0,1,2,2,4,4,1)))
}

private class Solution2404 {
    fun mostFrequentEven(nums: IntArray): Int {
        val evenCountMap = HashMap<Int, Int>()
        var mostFrequentEven = -1
        var maxFrequency = 0

        for (num in nums) {
            if (num % 2 == 0) {
                val currentCount = evenCountMap.getOrDefault(num, 0) + 1
                evenCountMap[num] = currentCount

                if (currentCount > maxFrequency || (currentCount == maxFrequency && num < mostFrequentEven)) {
                    mostFrequentEven = num
                    maxFrequency = currentCount
                }
            }
        }

        return if (mostFrequentEven != -1) mostFrequentEven else -1
    }
}