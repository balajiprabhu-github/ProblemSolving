package easy

fun main() {
    println(Solution1342().numberOfSteps(14).toString())
}

private class Solution1342 {
    fun numberOfSteps(num: Int): Int {

        var ans = 0
        var number = num

        while(number>0){
            if(number % 2 == 0){
                number/=2
            }else{
                number-=1
            }
            ans++
        }

        return ans
    }
}