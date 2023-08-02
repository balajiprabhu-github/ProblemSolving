package easy

import java.lang.StringBuilder

fun main() {
    println(Solution2788().splitWordsBySeparator(listOf("one.two.three","four.five","six"),'.').toString())
    println(Solution2788().splitWordsBySeparator(listOf("|||"),'|').toString())
}

private class Solution2788 {
    fun splitWordsBySeparator(words: List<String>, separator: Char): List<String> {
        return words.flatMap {
            it.split(separator)
        }.filter {
            it.isNotEmpty()
        }
    }
}