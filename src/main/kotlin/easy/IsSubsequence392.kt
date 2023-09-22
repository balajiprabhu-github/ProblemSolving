package easy

fun main() {
    println(Solution392().isSubsequence("abc","adhbskdc"))
}

private class Solution392 {
    fun isSubsequence(s: String, t: String): Boolean {
        if (s.isEmpty()) {
            return true
        }
        var i = 0

        for(j in t) {
            if(i < s.length && s[i] == j)   {
                i++
            }
        }

        return i == s.length
    }
}