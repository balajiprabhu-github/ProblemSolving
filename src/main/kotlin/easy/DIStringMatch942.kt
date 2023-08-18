package easy

fun main() {
    println(Solution942().diStringMatch("IDID").contentToString())
}

private class Solution942 {
    fun diStringMatch(s: String): IntArray {
        var start = 0
        var end = s.length
        val result = IntArray(s.length+1)

        for(i in s.indices) {
            if(s[i] == 'I') {
                result[i] = start
                start++
            } else {
                result[i] = end
                end--
            }

            if(i == s.length-1) {
                if(s[i] == 'I') {
                    result[i+1] = start
                } else {
                    result[i+1] = end
                }
            }
        }

        return result
    }
}