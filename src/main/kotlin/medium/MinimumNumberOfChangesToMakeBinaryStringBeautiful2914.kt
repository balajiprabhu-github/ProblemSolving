package medium

class Solution2914 {
    fun minChanges(s: String): Int {
        var count = 0

        for(i in 1 until s.length step 2) {
            if(s[i-1] != s[i]) {
                count++
            }
        }

        return count
    }
}