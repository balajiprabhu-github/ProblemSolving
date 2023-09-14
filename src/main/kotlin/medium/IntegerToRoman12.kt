package medium

fun main() {
    println(Solution12().intToRoman(1996))
}

private class Solution12 {
    fun intToRoman(num: Int): String {
        var n = num
        val sb = StringBuilder("")

        val values = intArrayOf(1,4,5,9,10,40,50,90,100,400,500,900,1000)
        val romans = arrayOf("I","IV","V","IX","X","XL","L","XC","C","CD","D","CM","M")

        for(i in values.indices.reversed()) {
            while(n >= values[i]) {
                sb.append(romans[i])
                n -= values[i]
            }
        }

        return sb.toString()
    }
}