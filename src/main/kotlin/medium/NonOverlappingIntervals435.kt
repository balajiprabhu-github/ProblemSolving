package medium

fun main() {
    println(Solution435().eraseOverlapIntervals(arrayOf(
        intArrayOf(1,2),
        intArrayOf(2,3),
        intArrayOf(3,4),
        intArrayOf(1,3),
        )))

    println(Solution435().eraseOverlapIntervals(arrayOf(
        intArrayOf(1,2),
        intArrayOf(1,2),
        intArrayOf(1,2),
    )))

    println(Solution435().eraseOverlapIntervals(arrayOf(
        intArrayOf(1,2),
        intArrayOf(1,3),
    )))
}

private class Solution435 {
    fun eraseOverlapIntervals(intervals: Array<IntArray>): Int {

        intervals.sortWith(compareBy<IntArray> { it[0] }.thenBy { it[1] })

        var count = 0
        var previousEnd = intervals[0][1]

        for (i in 1 until intervals.size) {
            if (intervals[i][0] >= previousEnd) {
                previousEnd = intervals[i][1]
            } else {
                count += 1
                previousEnd = Math.min(intervals[i][1],previousEnd)
            }
        }

        return count
    }
}