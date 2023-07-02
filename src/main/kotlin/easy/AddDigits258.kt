package easy

fun main() {
    println(Solution258().addDigits(38))
    println(Solution258().addDigits(0))
}

private class Solution258 {
    fun addDigits(num: Int): Int {

        if(num < 9){
            return num
        }

        var result = 0
        var n = num


        while(n > 0) {
            result += n%10
            n /= 10
            if (n == 0 && result > 9){
                n = result
                result = 0
            }
        }

        return result
    }
}