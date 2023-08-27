package easy

fun main() {

    println(Solution2496().maximumValue(arrayOf("alic3","bob","3","4","00000")))
    println(Solution2496().maximumValue(arrayOf("1","01","001","0001")))

}

private class Solution2496 {
    fun maximumValue(strs: Array<String>): Int {

        var result = Int.MIN_VALUE

        for (str in strs) {

            val currentMax = if (str.contains(Regex("[a-z]"))) {
                str.length
            } else {
                str.toInt()
            }

            result = Math.max(result,currentMax)
        }

        return result
    }
}