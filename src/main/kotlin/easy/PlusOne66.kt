package easy

fun main() {
    println(Solution66().plusOne(intArrayOf(1,2,3)).toList().toString())
    println(Solution66().plusOne(intArrayOf(4,3,2,1)).toList().toString())
    println(Solution66().plusOne(intArrayOf(9,9,9,9,9)).toList().toString())
    println(Solution66().plusOne(intArrayOf(7,8,2,5,9)).toList().toString())
}

private class Solution66 {

    fun plusOne(digits: IntArray): IntArray {

        for ((i,digit) in digits.withIndex().reversed()) {
            if (digit < 9) {
                digits[i] += 1
                return digits
            } else {
                digits[i] = 0
            }
        }

        return IntArray(digits.size + 1).apply {
            this[0] = 1
        }
    }
}