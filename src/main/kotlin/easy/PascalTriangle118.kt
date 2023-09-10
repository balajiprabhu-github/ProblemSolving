package easy

fun main() {
    println(Solution118().generate(30))
}

private class Solution118 {
    fun generate(numRows: Int): List<List<Int>> {
        val result: MutableList<MutableList<Int>> = mutableListOf()

        if(numRows == 1) {
            result.add(mutableListOf(1))
            return result
        }

        if(numRows == 2) {
            result.add(mutableListOf(1))
            result.add(mutableListOf(1,1))
            return result
        }

        if(numRows > 2) {
            result.add(mutableListOf(1))
            result.add(mutableListOf(1,1))
            for(i in 2 until numRows) {
                val list = mutableListOf<Int>()
                for(j in 0..i) {
                    if(j == 0 || j == i) {
                        list.add(1)
                    } else {
                        val prevList = result[i-1]
                        val num = prevList[j-1] + prevList[j]
                        list.add(num)
                    }
                }
                result.add(list)
            }
        }

        return result
    }
}