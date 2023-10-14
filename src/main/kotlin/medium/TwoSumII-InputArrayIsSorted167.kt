package medium

fun main() {
    println(Solution167().twoSum(intArrayOf(2,7,11,15),9))
}

private class Solution167 {
    fun twoSum(numbers: IntArray, target: Int): IntArray {

        var left = 0
        var right = numbers.size - 1

        while (left < right) {
            val sum = numbers[left] + numbers[right]
            if (sum == target) {
                return intArrayOf(left + 1, right + 1)  // Return 1-indexed array
            } else if (sum < target) {
                left++
            } else {
                right--
            }
        }

        return intArrayOf()

    }
}