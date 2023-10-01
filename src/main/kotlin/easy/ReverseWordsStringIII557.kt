package easy

import java.lang.StringBuilder

fun main() {
    println(Solution557().reverseWordsII("Let's take LeetCode contest").toString())
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

    fun reverseWordsII(s:String) : String {

        val result = s.toCharArray()

        var i = 0
        var j = 0

        while (j < result.size ) {

            if (result[j] == ' ' || j == result.size-1) {
                var start = i
                var end = if (j == result.size-1) j else j-1

                while (start < end) {
                    val temp = result[start]
                    result[start] = result[end]
                    result[end] = temp
                    start++
                    end--
                }

                j++
                i = j
            } else {
                j++
            }
        }

        return result.joinToString("")

    }
}