package easy

fun main() {
    println(Solution1704().halvesAreAlike("AbCdEfGh"))
    println(Solution1704().halvesAreAlike("book"))
    println(Solution1704().halvesAreAlike("textbook"))
    println(Solution1704().halvesAreAlike("Ieei"))
}

private class Solution1704 {
    fun halvesAreAlike(s: String): Boolean {
        val vowels = setOf('a','e','i','o','u')

        var i = 0
        var j = (s.length/2)
        var leftCount = 0
        var rightCount = 0

        while(j < s.length) {

            if(vowels.contains(s[i].toLowerCase())) {
                leftCount++
            }

            if(vowels.contains(s[j].toLowerCase())) {
                rightCount++
            }

            i++
            j++

        }

        return leftCount == rightCount
    }
}