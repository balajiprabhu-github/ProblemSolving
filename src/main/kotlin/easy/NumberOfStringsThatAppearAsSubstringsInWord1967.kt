package easy

fun main() {
    Solution1967().numOfStrings(arrayOf("a","abc","bc","d"),"abc")
}

private class Solution1967 {
    fun numOfStrings(patterns: Array<String>, word: String): Int {
        return patterns.toList().count {word.contains(it)}
    }
}