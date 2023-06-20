package easy

fun main() {
    println(Solution2652().sumOfMultiples(7))
}

private class Solution2652 {
    fun sumOfMultiples(n: Int): Int {
        var result = 0

        for(i in 1..n){
            if(i % 3 == 0 || i % 5 == 0 || i%7 == 0){
                result+=i
            }
        }

        return result
    }
}