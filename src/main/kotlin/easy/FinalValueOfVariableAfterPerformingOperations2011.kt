package easy

fun main() {
    println(Solution2011().finalValueAfterOperations(arrayOf("--X","X++","X++")))
}

private class Solution2011 {
    fun finalValueAfterOperations(operations: Array<String>): Int {
        var x = 0

        for (op in operations){
            when (op) {
                "X++" -> {
                    x++
                }
                "++X" -> {
                    ++x
                }
                "X--" -> {
                    x--
                }
                "--X" -> {
                    --x
                }
            }
        }

        return x
    }
}