package easy

fun main() {
    println(Solution1979().findGCD(intArrayOf(2,5,6,9,10)))
}

private class Solution1979 {
    fun findGCD(nums: IntArray): Int {
        var small = nums[0]
        var large = nums[0]

        for(i in nums) {
            if(i < small) {
                small = i
            }

            if(i > large) {
                large = i
            }
        }

        return gcd(small,large)
    }

    private fun gcd(a:Int ,b:Int) : Int {
        return if(b == 0) {
            a
        } else {
            gcd(b,a%b)
        }
    }
}