package easy

fun main() {
    println(Solution119().getRow(4))
}

private class Solution119 {
    fun getRow(rowIndex: Int): List<Int> {

        if(rowIndex <= 1) {
            return List(rowIndex+1){1}
        }

        val result = mutableListOf<MutableList<Int>>(mutableListOf<Int>())

        result.add(MutableList(1){1})
        result.add(MutableList(2){1})

        for(i in 2..rowIndex) {
            val currentRow = MutableList(i+1){1}
            for(j in 1 until i) {
                val sum = result[i][j-1] + result[i][j]
                currentRow[j] = sum
            }
            result.add(currentRow)
        }

        return result[rowIndex+1]

    }
}