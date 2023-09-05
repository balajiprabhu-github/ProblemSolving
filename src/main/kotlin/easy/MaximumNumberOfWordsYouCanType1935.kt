package easy

fun main() {
    println(Solution1935().canBeTypedWords("hello world","ad"))
    println(Solution1935().canBeTypedWords("leet code","lt"))
    println(Solution1935().canBeTypedWords("leet code","e"))
}

private class Solution1935 {
    fun canBeTypedWords(text: String, brokenLetters: String): Int {
        val brokenSet = brokenLetters.toSet()
        val words = text.split(" ")
        var count = 0

        for (word in words) {
            if (word.none { it in brokenSet }) {
                count++
            }
        }

        return count
    }
}