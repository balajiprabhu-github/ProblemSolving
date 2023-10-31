package medium

fun main() {
    println(Solution2433().findArray(intArrayOf(5,2,0,3,1)))
}

private class Solution2433 {
    fun findArray(pref: IntArray): IntArray {
        val result = IntArray(pref.size)
        result[0] = pref[0]
        for(i in 1 until pref.size) {
            result[i] = pref[i-1].xor(pref[i])
        }

        return result
    }
}