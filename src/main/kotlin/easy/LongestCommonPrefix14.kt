package easy

import java.lang.StringBuilder

fun main() {
    println(Solution14().longestCommonPrefix(arrayOf("clutch","club","clumsy","clue","cluster")))
    println(Solution14().longestCommonPrefix(arrayOf("flower","flow","flight")))
    println(Solution14().longestCommonPrefix(arrayOf("cir","car")))
}

// Input: strs = ["flower","flow","flight"]
class Solution14 {

    fun longestCommonPrefix(strs: Array<String>): String {

        if (strs.isEmpty()) return ""

        val result = StringBuilder("")

        var maxPrefixLength = Int.MAX_VALUE

        for (str in strs) {
            if (str.length < maxPrefixLength ) {
                maxPrefixLength = str.length
            }
        }

        for (i in 0 until maxPrefixLength) {

            var isPrefix = false

            for(str in strs) {
                if (str[i] == strs[0][i]) {
                    isPrefix = true
                } else {
                    isPrefix = false
                    break
                }
            }

            if (isPrefix) {
                result.append(strs[0][i])
            } else {
                break
            }
        }

        return result.toString()
    }
}