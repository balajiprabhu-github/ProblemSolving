package easy

fun main() {
    println(Solution1941().areOccurrencesEqual("abacbc"))
    println(Solution1941().areOccurrencesEqual("aabacbc"))
    println(Solution1941().areOccurrencesEqual("aaabb"))
    println(Solution1941().areOccurrencesEqual("a"))
}

private class Solution1941 {
    fun areOccurrencesEqual(s: String): Boolean {
        val charFrequency = mutableMapOf<Char, Int>()

        for (char in s) {
            charFrequency[char] = charFrequency.getOrDefault(char, 0) + 1
        }

        val frequencySet = charFrequency.values.toSet()
        return frequencySet.size == 1
    }
}