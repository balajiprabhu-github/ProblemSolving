package easy

fun main() {
    println(Solution58().lengthOfLastWord("Hello World"))
    println(Solution58().lengthOfLastWord("   fly me   to   the moon  "))
    println(Solution58().lengthOfLastWord("luffy is still joyboy"))
}

class Solution58 {
    fun lengthOfLastWord(s: String): Int {

        var lastWordLength = 0
        var tempCount = 0

        for(c in s) {
            if (!c.isWhitespace()){
                tempCount++
                lastWordLength = tempCount
            } else {
                tempCount = 0
            }
        }

        return lastWordLength
    }
}