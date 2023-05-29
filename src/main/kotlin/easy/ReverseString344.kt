package easy

fun main() {
    //Input: s = ['H','a','n','n','a','h']
    //Output: ['h','a','n','n','a','H']
    Solution344().reverseString(charArrayOf('h','e','l','l','o'))
    Solution344().reverseString(charArrayOf('H','a','n','n','a','h'))
}

private class Solution344 {
    fun reverseString(s: CharArray): Unit {
        var start = 0
        var end = s.size-1

        while (start<=end) {
            val first = s[start]
            val last = s[end]
            s[start] = last
            s[end] = first
            start++
            end--
        }

        println(s.toList().toString())
    }
}