package easy

fun main() {
    Solution2769().theMaximumAchievableX(4,1)
}

class Solution2769 {
    fun theMaximumAchievableX(num: Int, t: Int): Int {
        return num + t + t
    }
}