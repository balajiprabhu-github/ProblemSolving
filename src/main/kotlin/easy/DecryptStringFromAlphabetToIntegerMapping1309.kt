package easy

fun main() {
    println(Solution1309().freqAlphabets("10#11#12"))
    println(Solution1309().freqAlphabets("1326#"))
}

private class Solution1309 {
    fun freqAlphabets(s: String): String {

        val result  = StringBuilder("")
        var i = s.length-1
        while (i >= 0) {
            if (s[i] == '#') {
                val temp = s.substring(i-2,i).toInt() + 96
                result.append(temp.toChar())
                i -= 3
            } else {
                val temp = s[i].toString().toInt() + 96
                result.append(temp.toChar())
                i--
            }
        }

        return result.toString().reversed()
    }
}