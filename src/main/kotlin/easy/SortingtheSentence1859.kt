package easy

import java.lang.StringBuilder

fun main() {
    println(Solution1859().sortSentence("is2 sentence4 This1 a3"))
    println(Solution1859().sortSentence("Myself2 Me1 I4 and3"))
}

private class Solution1859 {
    fun sortSentence(s: String): String {

        val result = StringBuilder("")
        val words = s.split(" ")
        val wordMap = mutableMapOf<Int,String>()

        for (word in words) {
            wordMap[word[word.length-1].digitToInt()] = word
        }

        wordMap.toSortedMap().forEach { (i,v) ->

            result.append(v.substring(0,v.length-1))

            if (i != wordMap.size) {
                result.append(" ")
            }

        }


        return result.toString()
    }
}