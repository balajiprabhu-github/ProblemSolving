package easy

fun main() {
    println(Solution2000().reversePrefix("abcdefd",'d'))
    println(Solution2000().reversePrefix("xyxzxe",'z'))
    println(Solution2000().reversePrefix("abcd",'z'))
}

private class Solution2000 {
    fun reversePrefix(word: String, ch: Char): String {
        for (i in word.indices) {
            if (word[i] == ch) {
                val result = word.toCharArray()
                var start = 0
                var end = i
                while (start < end) {
                    val temp = result[start]
                    result[start] = result[end]
                    result[end] = temp
                    start++
                    end--
                }
                return result.joinToString("")
            }
        }
        return word
    }
}