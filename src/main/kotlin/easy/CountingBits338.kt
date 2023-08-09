package easy

fun main() {
    println(Solution338().countBits(5).contentToString())
    println(Solution338().countBits(0).contentToString())
}

private class Solution338 {
    fun countBits(n: Int): IntArray {
        val ans = IntArray(n+1){0}

        if (n == 0) return ans

        for (i in 1..n) {
            var temp = i
            var value = 0
            while (temp > 0) {
                value += temp % 2
                temp /= 2
            }
            ans[i] = value
        }

        return ans
    }
}