package medium

import kotlin.math.abs

fun main() {
    println(Solution50().myPow(2.00000,10))
}

private class Solution50 {
    fun myPow(x: Double, n: Int): Double {

        val num: Double = if (n < 0) 1/x else x
        var power: Long = abs(n.toLong())
        var product: Double = num
        var res = 1.0
        while (power > 0) {
            if (power%2 == 1L) {
                res *= product
            }
            power /= 2
            product *= product
        }
        return res
    }
}