package easy

fun main() {
    println(Solution844().backspaceCompare("ab#c","ad#c"))
}

private class Solution844 {
    fun backspaceCompare(s: String, t: String): Boolean {
        fun processString(input: String): String {
            val stack = mutableListOf<Char>()
            for (char in input) {
                if (char != '#') {
                    stack.add(char)
                } else if (stack.isNotEmpty()) {
                    stack.removeAt(stack.size - 1)
                }
            }
            return stack.joinToString("")
        }

        return processString(s) == processString(t)
    }
}