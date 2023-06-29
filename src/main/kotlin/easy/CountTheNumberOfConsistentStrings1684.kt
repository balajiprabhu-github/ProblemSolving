package easy

fun main() {
    println(Solution1684().countConsistentStrings("ab", arrayOf("ad","bd","aaab","baa","badab")))
    println(Solution1684().countConsistentStrings("abc", arrayOf("a","b","c","ab","ac","bc","abc")))
    println(Solution1684().countConsistentStrings("cad", arrayOf("a","b","c","ab","ac","bc","abc")))
}

private class Solution1684 {
    fun countConsistentStrings(allowed: String, words: Array<String>): Int {
        var ans = 0

        for (word in words) {
            var temp = 0
            for (c in word.toCharArray()) {
                if (allowed.contains(c)) {
                    temp++
                }
            }

            if (temp == word.length) {
                ans++
            }
        }

        return ans
    }
}