package easy

import java.util.*

fun main() {
    println(Solution2160().minimumSum(2932))
    println(Solution2160().minimumSum(4009))
    println(Solution2160().minimumSum(1547))
}

private class Solution2160 {
    fun minimumSum(num: Int): Int {
        val array = num.toString().toCharArray()

        Arrays.sort(array)

        val num1 = "${array[0].toString().toInt()}${array[2].toString().toInt()}"
        val num2 = "${array[1].toString().toInt()}${array[3].toString().toInt()}"

        println("$num1 $num2")

        return num1.toInt()+num2.toInt()
    }
}