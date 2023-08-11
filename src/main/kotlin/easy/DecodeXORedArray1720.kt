package easy

fun main() {
    println(Solution1720().decode(intArrayOf(1,2,3),1).contentToString())
}

private class Solution1720 {
    fun decode(encoded: IntArray, first: Int): IntArray {
        val result = IntArray(encoded.size+1)
        result[0] = first

        for(i in encoded.indices) {
            result[i+1] = encoded[i].xor(result[i])
        }

        return result
    }
}