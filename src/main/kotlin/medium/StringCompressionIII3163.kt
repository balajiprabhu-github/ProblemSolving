package medium

class Solution3163 {
    private fun compressedString(word: String): String {
        val comp = StringBuilder("")
        val n = word.length
        var count = 1
        var prev = word[0]

        for(i in 1 until n) {
            if(prev == word[i] && count < 9) {
                count++
            } else {
                comp.append(count).append(prev)
                count = 1
                prev = word[i]
            }
        }

        comp.append(count).append(prev)

        return comp.toString()
    }
}