package easy

fun main() {
    println(Solution1952().isThree(4))
}

private class Solution1952 {
    fun isThree(n: Int): Boolean {
        var count = 0

        for(i in 1..n/2) {
            if(n%i == 0) {
                count++
            }
        }

        return count+1 == 3
    }
}