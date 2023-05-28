package easy

fun main() {

    Solution().mySqrt(16)
}

private class Solution {

    fun mySqrt(x: Int): Int {

        var start : Long = 0
        var end : Long = x.toLong()
        var result : Long = 0

        while(start<=end) {

            val mid : Long = start+((end-start)/2)

            val sqr : Long = mid*mid

            if(sqr > x.toLong()) {
                end = mid-1
            }else if(sqr < x) {
                result = Math.max(result,mid)
                start = mid+1
            } else {
                return mid.toInt()
            }
        }

        return result.toInt()
    }
}