package medium


private class Solution36 {
    fun isValidSudoku(board: Array<CharArray>): Boolean {
        val set = mutableSetOf<String>()

        for (row in 0 until 9) {
            for (col in 0 until 9) {
                val num = board[row][col]

                if (num != '.') {

                    val rowKey = "$num in rowKey $row"
                    val colKey = "$num in colKey $col"
                    val boxKey = "$num in box ${row/3} - ${col/3}"

                    if (set.contains(rowKey) || set.contains(colKey) || set.contains(boxKey)) {
                        return false
                    }

                    set.add(rowKey)
                    set.add(colKey)
                    set.add(boxKey)
                }


            }
        }

        return true
    }
}