package easy

fun main() {
    println(Solution2108().firstPalindrome(arrayOf("njzejpscyerhspkqnllhlgoijvtuzwxmesdauvs")))
}

private class Solution2108 {
    fun firstPalindrome(words: Array<String>): String {

        for(word in words) {
            if(word.reversed() == word){
                return word
            }
        }

        return ""
    }

    fun isPalindrome(word:String) : Boolean {

        if(word.length == 1) return true

        var start = 0
        var end = word.length-1
        var isPalindrome = false

        while(start < end){
            if (word[start] == word[end]) {
                isPalindrome = true
            } else {
                break
            }
            start++
            end--
        }

        return isPalindrome
    }
}