package easy

fun main() {
    println(Solution2553().separateDigits(intArrayOf(13,25,83,77)).contentToString())
    println(Solution2553().separateDigits(intArrayOf(7,1,3,9)).contentToString())
}

private class Solution2553 {
    fun separateDigits(nums: IntArray): IntArray {
        val result = mutableListOf<Int>()
        for (i in nums) {
            if (i > 9) {
                var num = i
                val temp = mutableListOf<Int>()
                while (num > 0) {
                    temp.add(num%10)
                    num /= 10
                }
                result.addAll(temp.reversed())
            } else {
                result.add(i)
            }
        }

        return result.toIntArray()
    }
}