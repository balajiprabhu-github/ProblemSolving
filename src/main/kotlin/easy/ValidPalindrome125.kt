package easy

fun main() {
        println(Solution125().isPalindrome("A man, a plan, a canal: Panama"))
        println(Solution125().isPalindrome("race a car"))
        println(Solution125().isPalindrome(" "))
        println(Solution125().isPalindrome("."))
}

private class Solution125 {

    fun isPalindrome(s: String): Boolean {

        val list = mutableListOf<Char>()

        for (ch in s) {
            if ((ch in '0'..'9') || (ch.lowercaseChar() in 'a'..'z')) {
                list.add(ch.lowercaseChar())
            }
        }

        println(list.joinToString(""))
        var start = 0
        var end = list.size-1

        while(start<=end) {
            if(list[start] != list[end]) {
                return false
            }
            start++
            end--
        }

        return true
    }
}