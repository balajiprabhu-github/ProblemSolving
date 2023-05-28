package easy

fun main() {
    println(Solution13().romanToInt("XXVII"))
}

private class Solution13 {

    fun romanToInt(s: String): Int {

        val romanMap = mapOf('I' to 1, 'V' to 5, 'X' to 10, 'L' to 50, 'C' to 100, 'D' to 500, 'M' to 1000)

        var result : Int = 0
        var currentIndex : Int = 0
        var nextIndex : Int = if (s.isNotEmpty()) 1 else -1

        while (nextIndex <= s.length) {

            val currentValue = romanMap[s[currentIndex]]!!
            val nextValue = if (nextIndex == s.length) 0 else romanMap[s[nextIndex]]!!

            if (currentValue < nextValue) {
                result += (nextValue-currentValue)
                currentIndex += 2
                nextIndex += 2
            } else {
                result += currentValue
                currentIndex += 1
                nextIndex += 1
            }
        }

        return result
    }
}