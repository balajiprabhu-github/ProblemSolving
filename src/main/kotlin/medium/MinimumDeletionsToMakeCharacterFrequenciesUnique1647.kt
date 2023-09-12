package medium

fun main() {
    println(Solution1647().minDeletions("aaabbbcc"))
}

private class Solution1647 {
    fun minDeletions(s: String): Int {

        val frequencyMap = s.groupingBy { it }.eachCount()
        val frequencySet = mutableSetOf<Int>()

        var count = 0

        frequencyMap.forEach { frequency ->
            var currentFrequency = frequency.value
            while (currentFrequency > 0 && frequencySet.contains(currentFrequency)) {
                count++
                currentFrequency--
            }
            frequencySet.add(currentFrequency)
        }

        return count
    }
}