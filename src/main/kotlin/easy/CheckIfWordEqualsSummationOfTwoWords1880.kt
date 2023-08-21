package easy

fun main() {

    println(Solution1880().isSumEqual("acb","cba","cdb"))
    println(Solution1880().isSumEqual("aaa","a","aab"))
    println(Solution1880().isSumEqual("aaa","a","aaaa"))

}

private class Solution1880 {
    fun isSumEqual(firstWord: String, secondWord: String, targetWord: String): Boolean {
        return (getNumericValue(firstWord) + getNumericValue(secondWord)) == getNumericValue(targetWord)
    }

    fun getNumericValue(word: String) : Int {

        var num = 0
        var base10 = 1

        for (i in word.indices.reversed()) {
            val numericValue = word[i].toInt() - 97
            num += (numericValue * base10)
            base10 *= 10
        }

        return num
    }
}