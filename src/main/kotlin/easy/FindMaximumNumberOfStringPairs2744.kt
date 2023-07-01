package easy

fun main() {
    println(Solution2744().maximumNumberOfStringPairs(arrayOf("cd","ac","dc","ca","zz")))
}

private class Solution2744 {
    fun maximumNumberOfStringPairs(words: Array<String>): Int {

        val set = mutableSetOf<String>()
        var result = 0

        for (word in words) {
            if (set.contains(word.reversed())) {
                result++
            } else {
                set.add(word)
            }
        }

        return result

    }
}