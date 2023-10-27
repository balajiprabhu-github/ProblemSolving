package medium

fun main() {
    println(Solution5().longestPalindrome("babaa"))
}

private class Solution5 {
    fun longestPalindrome(s: String): String {
        var result = ""
        for(i in s.indices) {
            for(j in i..s.length) {
                val substring = s.substring(i,j)
                if(isPalindrome(substring) && result.length < substring.length) {
                    result = substring
                }
            }
        }

        return result
    }

    fun isPalindrome(s: String) : Boolean {
        var start = 0
        var end = s.length-1

        while(start <= end) {
            if(s[start] != s[end]) {
                return false
            }
            start++
            end--
        }

        return true
    }
}