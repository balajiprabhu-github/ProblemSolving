package easy

import java.util.*

fun main() {
    println(Solution151().reverseWords("the sky is blue"))
    println(Solution151().reverseWords("  hello world  "))
    println(Solution151().reverseWords("a good   example"))
}

class Solution151 {
    fun reverseWords(s: String): String {

        val list = mutableListOf<String>()

        var slow = 0
        var fast = 0

        while(fast < s.length) {
            if (s[fast] != ' ') {
                fast++
            } else {
                if (slow < fast) {
                    val word = s.substring(slow,fast)
                    list.add(word)
                    slow = fast
                } else {
                    slow++
                    fast++
                }
            }
        }

        if (slow != fast) {
            val word = s.substring(slow,fast)
            list.add(word)
        }

        list.reverse()

        return list.joinToString(" ")
    }
}