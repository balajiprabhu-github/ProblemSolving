package easy

fun main() {
    println(Solution1221().balancedStringSplit("RLRRLLRLRL"))
    println(Solution1221().balancedStringSplit("RLRRRLLRLL"))
    println(Solution1221().balancedStringSplit("LLLLRRRR"))
}

private class Solution1221 {
    fun balancedStringSplit(s: String): Int {
        var l = 0
        var r = 0
        var result = 0

        for(i in s.indices){

            if(s[i] == 'L'){
                l++
            } else {
                r++
            }

            if(l == r){
                result++
            }
        }

        return result
    }
}