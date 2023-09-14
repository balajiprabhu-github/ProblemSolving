package easy

fun main() {
    println(Solution509().fib(5))
}

private class Solution509 {
    fun fib(n: Int): Int {

        if (n <= 1) {
            return n
        }

        var a = 0
        var b = 1
        var sum : Int

        for (i in 2..n) {
            sum = a + b
            a = b
            b = sum
        }

        return b
    }
}