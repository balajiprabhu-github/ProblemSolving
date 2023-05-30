package easy

fun main() {
    println(Solution1281().subtractProductAndSum(4421))
}

private class Solution1281 {
    fun subtractProductAndSum(n: Int): Int {

        var product = 1
        var sum = 0
        var temp = n

        while (temp>0) {
            val remainder = temp%10
            product*= remainder
            sum += remainder
            temp /= 10
        }

        return product-sum
    }
}