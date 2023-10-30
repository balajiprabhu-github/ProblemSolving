package easy

fun main() {
    println(Solution1356().sortByBits(intArrayOf(0,1,2,3,4,5,6,7,8)))
}

private class Solution1356 {
    fun sortByBits(arr: IntArray): IntArray {

        val counts = mutableListOf<Pair<Int, Int>>()

        for (i in arr.indices) {
            var bitCount = 0
            var element = arr[i]
            while (element > 0) {
                if (element and 1 == 1) {
                    bitCount += 1
                }
                element = element shr 1
            }
            counts.add(Pair(bitCount, arr[i]))
        }

        counts.sortWith(compareBy({ it.first }, { it.second }))

        val output = IntArray(arr.size)
        for (i in arr.indices) {
            output[i] = counts[i].second
        }

        return output
    }
}