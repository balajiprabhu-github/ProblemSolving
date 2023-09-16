package easy

import kotlin.math.pow

fun main() {
    println(Solution202().isHappy(19))
    println(Solution202().isHappy(2))
    println(Solution202().isHappy(61))
}

private class Solution202 {
    fun isHappy(n: Int): Boolean {

        val set = mutableSetOf<Int>()
        var num = n

        while(true) {

            var temp = num
            num = 0

            while(temp > 0) {
                val digit = temp%10
                num += digit * digit
                temp /= 10
            }

            if(num == 1) {
                return true
            }

            if(set.contains(num)) {
                return false
            }

            set.add(num)

        }

    }
}