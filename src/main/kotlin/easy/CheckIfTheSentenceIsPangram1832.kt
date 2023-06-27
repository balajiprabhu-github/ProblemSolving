package easy

fun main() {
    println(Solution1832().checkIfPangram("thequickbrownfoxjumpsoverthelazydog"))
    println(Solution1832().checkIfPangram("leetcode"))
}

private class Solution1832 {
    fun checkIfPangram(sentence: String): Boolean {
        for(c in 'a'..'z'){
            if(!sentence.contains(c)){
                return false
            }
        }
        return true
    }
}