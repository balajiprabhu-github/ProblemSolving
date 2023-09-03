package easy

fun main() {
    println(Solution1207().uniqueOccurrences(intArrayOf(1,2,2,1,1,3)))
    println(Solution1207().uniqueOccurrences(intArrayOf(1,2)))
    println(Solution1207().uniqueOccurrences(intArrayOf(-3,0,1,-3,1,1,1,-3,10,0)))
}

private class Solution1207 {
    fun uniqueOccurrences(arr: IntArray): Boolean {

        val hashMap = mutableMapOf<Int,Int>()
        for (i in arr.indices) {
            hashMap[arr[i]] = hashMap.getOrDefault(arr[i],0)+1
        }

        return hashMap.size == hashMap.values.toSet().size

    }
}