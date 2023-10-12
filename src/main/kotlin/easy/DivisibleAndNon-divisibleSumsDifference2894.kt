package easy

fun main() {
    println(Solution2894().differenceOfSums(10,3))
}

private class Solution2894 {
    fun differenceOfSums(n: Int, m: Int): Int {
        var result = 0

        for(i in 1..n) {
            if(i % m != 0) {
                result += i
            } else {
                result -= i
            }
        }

        return result
    }
}