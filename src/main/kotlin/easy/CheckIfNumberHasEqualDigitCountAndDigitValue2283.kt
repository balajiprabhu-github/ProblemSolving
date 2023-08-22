package easy

fun main() {
    println(Solution2283().digitCount("1210"))
    println(Solution2283().digitCount("030"))
}

private class Solution2283 {
    fun digitCount(num: String): Boolean {
        for (i in num.indices) {
            val count = num.count { it.toString() == i.toString() }
            if (count != num[i].toString().toInt()) {
                return false
            }
        }
        return true
    }
}