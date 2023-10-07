package easy

fun main() {
    println(Solution2810().finalString("string"))
}

private class Solution2810 {
    fun finalString(s: String): String {

        val sb = StringBuilder("")

        for(c in s) {
            if(c == 'i') {
                sb.reverse()
            } else {
                sb.append(c)
            }
        }
        return sb.toString()
    }
}