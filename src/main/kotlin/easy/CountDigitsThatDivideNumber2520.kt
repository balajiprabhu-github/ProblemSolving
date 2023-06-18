package easy

fun main(){
    println(Solution2520().countDigits(7))
    println(Solution2520().countDigits(121))
    println(Solution2520().countDigits(1248))
}

private class Solution2520 {
    fun countDigits(num: Int): Int {
        var result = 0
        var n = num
        while(n>0){
            var temp = n % 10
            if(num % temp == 0){
                result++
            }
            n /= 10
        }
        return result
    }
}