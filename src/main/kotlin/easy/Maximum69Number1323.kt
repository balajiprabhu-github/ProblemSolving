package easy

import java.lang.StringBuilder

fun main() {
    println(Solution1323().maximum69Number(9669))
    println(Solution1323().maximum69Number(9996))
    println(Solution1323().maximum69Number(9999))
}

private class Solution1323 {
    fun maximum69Number (num: Int): Int {

        val list = mutableListOf<Int>()

        for (i in 0 until num.toString().length) {

            val numString = StringBuilder(num.toString())

            if (numString[i] == '6') {
                numString.setCharAt(i,'9')
            } else {
                numString.setCharAt(i,'6')
            }

            list.add(Math.max(num,numString.toString().toInt()))
        }

        return list.max()
    }
}