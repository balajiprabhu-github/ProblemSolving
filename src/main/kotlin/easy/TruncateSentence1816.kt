package easy

fun main() {
    println(Solution1816().truncateSentence("Hello how are you Contestant",4))
    println(Solution1816().truncateSentence("What is the solution to this problem",4))
}

private class Solution1816 {
    fun truncateSentence(s: String, k: Int): String {
        var temp = k
        val result = StringBuilder("")

        for(i in s.indices) {
            if(s[i] == ' '){
                temp--
            }

            if(temp == 0) {
                break
            }

            result.append(s[i])
        }

        return result.toString()
    }
}