package easy

fun main() {
   println(Solution2325().decodeMessage("the quick brown fox jumps over the lazy dog","vkbs bs t suepuv"))
}


private class Solution2325 {
    fun decodeMessage(key: String, message: String): String {

        var alphabet = 'a'
        val map = mutableMapOf<Char,Char>()

        val result = StringBuilder("")

        for (c in key) {
            if (!c.isWhitespace() && !map.containsKey(c)){
                map[c] = alphabet
                alphabet += 1
            }
        }

        for (c in message) {
            if (c.isWhitespace()) {
                result.append(" ")
            } else {
                result.append(map[c])
            }
        }
        return result.toString()

    }
}