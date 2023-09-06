package easy

fun main() {
    println(Solution728().selfDividingNumbers(1,22 ))
    println(Solution728().selfDividingNumbers(47,85 ))
}

private class Solution728 {
    fun selfDividingNumbers(left: Int, right: Int): List<Int> {
        val result = mutableListOf<Int>()
        for (i in left..right) {
            var n = i
            var digitLength = 0
            var divideCount = 0
            var isZero = false
            var isUnDivisible = false
            while(n > 0) {
                val significantDigit = n%10
                if (significantDigit == 0) {
                    isZero = true
                    break
                }
                if (i % significantDigit == 0) {
                    divideCount++
                } else {
                    isUnDivisible = true
                    break
                }
                n /= 10
                digitLength++
            }

            if (digitLength == divideCount && !isZero && !isUnDivisible) {
                result.add(i)
            }
        }

        return result
    }
}