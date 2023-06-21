package easy

fun main() {
    println(Solution1768().mergeAlternately("abc","pqrs"))
}

private class Solution1768 {
    fun mergeAlternately(word1: String, word2: String): String {
        val result = StringBuilder("")
        var minLength = Math.min(word1.length,word2.length)

        for(i in 0 until minLength){
            result.append(word1[i])
            result.append(word2[i])
        }

        if(word1.length > word2.length) {

            for(i in minLength until word1.length){
                result.append(word1[i])
            }

        } else {

            for(i in minLength until word2.length){
                result.append(word2[i])
            }
        }

        return result.toString()

    }
}