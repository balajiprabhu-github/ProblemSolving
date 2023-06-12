package easy

fun main(){
    println(Solution228().summaryRanges(intArrayOf(0,1,2,4,5,7)).toString())
    println(Solution228().summaryRanges(intArrayOf(0,2,3,4,6,8,9)).toString())
}

private class Solution228 {
    fun summaryRanges(nums: IntArray): List<String> {
        val result = mutableListOf<String>()

        if (nums.isEmpty()){
            return emptyList()
        }

        if (nums.size == 1 ){
            return listOf("${nums[0]}")
        }

        var slow = 0
        var fast = 0

        while (true) {

            if (nums[fast]+1  == nums[fast+1] ) {
                fast++
            } else {
                if (slow == fast){
                    result.add("${nums[slow]}")
                } else {
                    result.add("${nums[slow]}->${nums[fast]}")
                }
                fast++
                slow = fast
            }

            if (fast == (nums.size-1)) {
                if (slow == fast){
                    result.add("${nums[slow]}")
                } else {
                    result.add("${nums[slow]}->${nums[fast]}")
                }
                return result
            }
        }
    }
}