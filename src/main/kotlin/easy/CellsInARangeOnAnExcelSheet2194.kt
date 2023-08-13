package easy

fun main() {
    println(Solution2194().cellsInRange("K1:L2").toString())
    println(Solution2194().cellsInRange("A1:F1").toString())
}

private class Solution2194 {
    fun cellsInRange(s: String): List<String> {
        val result = mutableListOf<String>()

        for (i in s[0]..s[3]) {
            for (j in s[1]..s[4]) {
                result.add("$i$j")
            }
        }
        return result
    }
}