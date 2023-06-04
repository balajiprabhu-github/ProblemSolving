package easy

fun main() {
    println(Solution1662().arrayStringsAreEqual(arrayOf("ab", "c"), arrayOf("a", "bc")))
    println(Solution1662().arrayStringsAreEqual(arrayOf("a", "cb"), arrayOf("a", "bc")))
}

private class Solution1662 {
    fun arrayStringsAreEqual(word1: Array<String>, word2: Array<String>): Boolean {
        var wordOne = ""
        var wordTwo = ""

        for(word in word1){
            wordOne += word
        }

        for(word in word2){
            wordTwo += word
        }

        return wordOne == wordTwo
    }
}