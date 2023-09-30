package easy

fun main() {
    println(Solution2427().commonFactors(12,6))
}

private class Solution2427 {
    fun commonFactors(a: Int, b: Int): Int {
        val gcdValue = gcd(a, b)
        var commonFactorsCount = 0

        for (i in 1..gcdValue) {
            if (gcdValue % i == 0) {
                commonFactorsCount++
            }
        }

        return commonFactorsCount
    }

    fun gcd(a: Int, b: Int): Int {
        if (b == 0) {
            return a
        }
        return gcd(b, a % b)
    }
}