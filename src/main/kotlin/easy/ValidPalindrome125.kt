package easy

fun main() {
        println(Solution125().isPalindrome("A man, a plan, a canal: Panama"))
        println(Solution125().isPalindrome("race a car"))
        println(Solution125().isPalindrome(" "))
        println(Solution125().isPalindrome("."))
}

private class Solution125 {

    fun isPalindrome(s: String): Boolean {

        if (s.length == 1) return true
        val re = Regex("[^A-Za-z]")
        val temp = s.toLowerCase().replace(re, "")
        var result = false
        var start = 0
        var end = temp.length-1

        while (start <= end){
            result = temp[start] == temp[end]
            start++
            end--
        }

        return result
    }
}