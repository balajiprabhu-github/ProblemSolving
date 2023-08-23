package easy

fun main() {
    println(Solution2678().countSeniors(arrayOf("7868190130M7522","5303914400F9211","9273338290F4010")))
    println(Solution2678().countSeniors(arrayOf("1313579440F2036","2921522980M5644")))
}

private class Solution2678 {
    fun countSeniors(details: Array<String>): Int {
        var result = 0
        for (detail in details) {
            val age = "${detail[11]}${detail[12]}".toInt()

            if (age > 60) {
                result++
            }
        }
        return result
    }
}