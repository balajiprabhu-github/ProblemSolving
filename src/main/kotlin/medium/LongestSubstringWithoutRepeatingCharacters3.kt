package medium

fun main() {
    println(Solution3().lengthOfLongestSubstring("abcabca"))
    println(Solution3().lengthOfLongestSubstring("bbbbb"))
    println(Solution3().lengthOfLongestSubstring("pwwkew"))
    println(Solution3().lengthOfLongestSubstring(" "))
    println(Solution3().lengthOfLongestSubstring("au"))
}

private class Solution3 {
    fun lengthOfLongestSubstring(s: String): Int {

        if (s.length == 1) {
            return s.length
        }

        var result = 0
        val set = mutableSetOf<Char>()
        for (i in s.indices) {
            var currentMax = 0
            var j = i
            while (j < s.length) {
                if (set.contains(s[j])) {
                    set.clear()
                    break
                } else {
                    set.add(s[j])
                    currentMax++
                    j++
                }
                result = Math.max(result,currentMax)

            }
        }

        return result
    }
}