package medium

fun main() {
    println(Solution985().sumEvenAfterQueries(intArrayOf(), arrayOf(intArrayOf(), intArrayOf(), intArrayOf(),
        intArrayOf()
    )))
}

private class Solution985 {
    fun sumEvenAfterQueries(nums: IntArray, queries: Array<IntArray>): IntArray {

        val result = IntArray(queries.size)

        for((i,query) in queries.withIndex()) {

            val value = query[0]
            val index = query[1]

            nums[index] = nums[index] + value

            var sum = 0
            for(num in nums) {
                if(num % 2 == 0) {
                    sum += num
                }
            }

            result[i] = sum

        }

        return result
    }
}