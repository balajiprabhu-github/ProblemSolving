package easy

fun main() {
    println(Solution28().strStr("sadbutsad","sad"))
}

private class Solution28 {
    fun strStr(haystack: String, needle: String): Int {
        val haystackLength = haystack.length
        val needleLength = needle.length

        if (needleLength == 0) {
            return 0
        }

        if (needleLength > haystackLength) {
            return -1
        }

        for (i in 0..haystackLength - needleLength) {
            var j = 0
            while (j < needleLength && haystack[i + j] == needle[j]) {
                j++
            }
            if (j == needleLength) {
                return i
            }
        }

        return -1
    }
}