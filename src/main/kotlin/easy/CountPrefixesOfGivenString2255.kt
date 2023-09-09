package easy

fun main() {
    println(Solution2255().countPrefixes(arrayOf("a","b","c","ab","bc","abc"),"abc"))
}

private class Solution2255 {
    fun countPrefixes(words: Array<String>, s: String): Int {
        var result = 0
        for (word in words) {
            if (s.startsWith(word)){
                result++
            }
        }

        return result
    }
}