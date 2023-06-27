package easy

fun main() {
    println(Solution2315().countAsterisks("l|*e*et|c**o|*de|"))
    println(Solution2315().countAsterisks("iamprogrammer"))
    println(Solution2315().countAsterisks("yo|uar|e**|b|e***au|tifu|l"))
}


private class Solution2315 {
    fun countAsterisks(s: String): Int {

        var barCount = 0
        var ans = 0

        for(i in s.indices) {
            if(s[i] == '|') {
                barCount++
            }

            if(s[i] == '*' && barCount % 2 == 0){
                ans++
            }
        }


        return ans
    }
}