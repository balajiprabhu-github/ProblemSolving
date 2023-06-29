package easy

fun main() {
    println(Solution2535().differenceOfSum(intArrayOf(1,15,6,3)))
    println(Solution2535().differenceOfSum(intArrayOf(1,2,3,4)))
}

private class Solution2535 {
    fun differenceOfSum(nums: IntArray): Int {
        var arraySum = 0
        var digitSum = 0

        for(i in nums) {
            arraySum+=i
        }

        for(i in nums) {
            if(i > 9) {
                var temp = i
                while(temp > 0){
                    digitSum+= (temp%10)
                    temp /= 10
                }
            }else {
                digitSum+= i
            }
        }

        return arraySum-digitSum
    }
}