package easy

fun main() {

    println(Solution1678().interpret("G()(al)"))
    println(Solution1678().interpret("G()()()()(al)"))
    println(Solution1678().interpret("(al)G(al)()()G"))

}

private class Solution1678 {
    fun interpret(command: String): String {
        val result = StringBuilder("")
        for (i in command.indices) {
            if(command[i] == 'G') {
                result.append("G")
            } else if(command[i] == '(' && command[i+1] == ')') {
                result.append("o")
            } else if(command[i] == '(' && command[i+1] == 'a') {
                result.append("al")
            }
        }

        return result.toString()
    }
}