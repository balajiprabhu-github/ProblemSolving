package easy

fun main() {
    println(Solution2413().smallestEvenMultiple(5))
    println(Solution2413().smallestEvenMultiple(6))
}


private class Solution2413 {
    fun smallestEvenMultiple(n: Int): Int {
        return if(n%2 == 0){
            n
        } else {
            n * 2
        }
    }
}