package easy

fun main() {
    println(Solution1844().replaceDigits("a1c1e1"))
    println(Solution1844().replaceDigits("a1b2c3d4e"))
}

private class Solution1844 {
    fun replaceDigits(s: String): String {

        val result = StringBuilder("")

        for(i in s.indices){
            if(i % 2 == 0) {
                result.append(s[i])
            }else {
                result.append(shift(s[i-1],s[i]))
            }
        }

        return result.toString()
    }

    fun shift(a: Char, b: Char) : Char = a+b.toString().toInt()
}