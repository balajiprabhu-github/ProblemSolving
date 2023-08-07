package easy

fun main() {
    Solution2798().numberOfEmployeesWhoMetTarget(intArrayOf(0,1,2,3,4),2)
    Solution2798().numberOfEmployeesWhoMetTarget(intArrayOf(5,1,4,2,2),6)
}

private class Solution2798 {
    fun numberOfEmployeesWhoMetTarget(hours: IntArray, target: Int): Int {
        var result = 0

        for(i in hours) {
            if(i >= target) {
                result++
            }
        }

        return result
    }
}