package easy

import java.lang.StringBuilder

fun main() {
    println(Solution557().reverseWords("Let's take LeetCode contest").toString())
}

//"Let's take LeetCode contest"
// "s'teL ekat edoCteeL tsetnoc"
private class Solution557 {
    fun reverseWords(s: String): String {
        val result = StringBuilder("")

        val words = s.split(" ")

        for ((i,word) in words.withIndex()) {
            val wordArr : CharArray = word.toCharArray()
            var start = 0
            var end = word.length-1

            while (start <= end){
                val temp = word[start]
                wordArr[start] = word[end]
                wordArr[end] = temp
                start++
                end--
            }

            for (c in wordArr) {
                result.append(c)
            }

            if (i != words.size-1){
                result.append(" ")
            }
        }

        return result.toString()
    }
}