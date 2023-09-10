package easy

fun main() {
    println(Solution2697().makeSmallestPalindrome("egcfe"))
}

private class Solution2697 {
    fun makeSmallestPalindrome(s: String): String {
        var start = 0
        var end = s.length-1
        val result = CharArray(s.length)
        while(start<=end) {
            val startChar = s[start]
            val endChar = s[end]

            if(startChar == endChar) {
                result[start] = startChar
                result[end] = endChar
            } else {
                if(startChar > endChar) {
                    result[start] = endChar
                    result[end] = endChar
                } else {
                    result[start] = startChar
                    result[end] = startChar
                }
            }

            start++
            end--

        }

        return result.joinToString("")
    }
}