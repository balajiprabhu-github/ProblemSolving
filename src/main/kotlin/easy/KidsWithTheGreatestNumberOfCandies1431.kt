package easy

fun main() {
    println(Solution1431().kidsWithCandies(intArrayOf(2,3,5,1,3),3))
    println(Solution1431().kidsWithCandies(intArrayOf(4,2,1,1,2),1))
    println(Solution1431().kidsWithCandies(intArrayOf(12,1,12),10))
}

private class Solution1431 {
    fun kidsWithCandies(candies: IntArray, extraCandies: Int): List<Boolean> {
        val result = mutableListOf<Boolean>()

        var max = -1
        for (i in candies) {
            max = Math.max(max,i)
        }

        for (i in candies.indices) {
            result.add(candies[i]+extraCandies >= max)
        }

        return result
    }
}