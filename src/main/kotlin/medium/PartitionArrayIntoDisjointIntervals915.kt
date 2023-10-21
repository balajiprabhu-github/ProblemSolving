package medium

fun main() {

}

public class Solution915 {
    fun partitionDisjoint(nums: IntArray): Int {
        
        // TODO: Unsolved

        val left = mutableListOf<Int>()

        left.add(nums[0])

        for(i in 1 until nums.size) {
            for(j in left) {
                if(nums[i] <= j) {
                    left.add(nums[i])
                    break
                }
            }
        }

        return left.size
    }
}