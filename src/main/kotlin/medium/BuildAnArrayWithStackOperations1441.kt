package medium

fun main() {
    println(Solution1441().buildArray(intArrayOf(1,3),3))
}

private class Solution1441 {
    fun buildArray(target: IntArray, n: Int): List<String> {

        val result = mutableListOf<String>()
        var i = 1
        var targetIndex = 0

        while (i <= n && targetIndex < target.size) {
            result.add("Push")

            if (target[targetIndex] == i) {
                targetIndex++
            } else {
                result.add("Pop")
            }

            i++
        }

        return result
    }
}