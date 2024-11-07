package medium

class Solution2275 {
    fun largestCombination(candidates: IntArray): Int {
        var maxFreq = 0

        for(i in 0 until 32) {
            var freq = 0
            for(c in candidates) {
                if((c shr i) % 2 == 1) {
                    freq++
                }
            }
            maxFreq = maxFreq.coerceAtLeast(freq)
        }

        return maxFreq
    }
}