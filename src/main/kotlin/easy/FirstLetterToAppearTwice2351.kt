package easy

fun main() {
    println(Solution2351().repeatedCharacter("abccbaacz"))
}

private class Solution2351 {
    fun repeatedCharacter(s: String): Char {
        var result : Char = ' '
        val set = mutableSetOf<Char>()

        for(i in s.indices) {
            if(set.contains(s[i])) {
                result = s[i]
                return result
            }else {
                set.add(s[i])
            }
        }

        return result
    }
}