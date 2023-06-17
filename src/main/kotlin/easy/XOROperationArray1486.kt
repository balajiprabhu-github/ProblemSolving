package easy

fun main() {
    println(Solution1486().xorOperation(5,0))
    println(Solution1486().xorOperation(4,3))
}

private class Solution1486   {
    fun xorOperation(n: Int, start: Int): Int {

        var result = 0
        val nums = IntArray(n)

        for (i in 0 until n){
            nums[i] = start + 2 * i
            result = result xor nums[i]
        }

        return result
    }
}