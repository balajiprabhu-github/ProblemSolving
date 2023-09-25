package easy

fun main() {
    println(Solution389().findTheDifference("abcd","abcde"))
}

private class Solution389 {
    fun findTheDifference(s: String, t: String): Char {

        val sChars = IntArray(26)
        val tChars = IntArray(26)

        for (i in s) {
            val index = i - 'a'
            sChars[index]++
        }

        for (i in t) {
            val index = i - 'a'
            tChars[index]++
        }

        for (i in 0 until 26) {
            if (sChars[i] != tChars[i]) {
                return (i + 'a'.toInt()).toChar()
            }
        }

        return '\u0000'
    }
}