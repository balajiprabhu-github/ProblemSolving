package easy

fun main() {
    println(Solution2235().sum(12,5))
}

private class Solution2235 {
    fun sum(num1: Int, num2: Int): Int {
        return if(-100 <= num1 && num2 <= 100) num1+num2 else 0
    }
}