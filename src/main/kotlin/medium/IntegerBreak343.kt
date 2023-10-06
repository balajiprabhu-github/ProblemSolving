package medium

fun main() {
    println(Solution343().integerBreak(10))
}

private class Solution343 {
    fun integerBreak(num: Int): Int {
        var n = num
        if(n == 2) return 1
        if(n == 3) return 2
        var result = 1
        while(n >= 3 && n-3>1) {
            result *= 3
            n -= 3
        }

        if(n!=0) {
            result *= n
        }

        return result
    }
}