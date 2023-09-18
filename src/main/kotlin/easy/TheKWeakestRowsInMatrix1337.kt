package easy

import java.util.*

data class Item(val index: Int, val count: Int)

fun main() {
    println(Solution1337().kWeakestRows(
        arrayOf(
            intArrayOf(1,1,0,0,0),
            intArrayOf(1,1,1,1,0),
            intArrayOf(1,0,0,0,0),
            intArrayOf(1,1,0,0,0),
            intArrayOf(1,1,1,1,1)
        ),3
    ).contentToString())
}

private class Solution1337 {
    fun kWeakestRows(mat: Array<IntArray>, k: Int): IntArray {
//        val map = mutableMapOf<Int,Int>()
//
//        for (i in mat.indices) {
//            var count = 0
//            for (j in mat[0].indices) {
//                if (mat[i][j] == 1) {
//                    count++
//                    map[i] = count
//                }
//            }
//        }
//
//        return  map.toList().sortedBy { (_,value) ->  value}.take(k).toMap().keys.toIntArray()
        val rowStrengths = mat.mapIndexed { index, row ->
            Pair(index, row.sum())
        }

        return rowStrengths.sortedWith(compareBy({ it.second }, { it.first }))
            .take(k)
            .map { it.first }
            .toIntArray()
    }

    fun kWeakestRowsSolution2(mat: Array<IntArray>, k: Int): IntArray {
        val comparator = compareBy<Item> { it.count }.thenBy { it.index }
        val pq = PriorityQueue(comparator)
        val result = IntArray(k)

        for(i in mat.indices) {
            val row = mat[i]
            val count = row.count { it == 1}
            val item = Item(i,count)
            pq.offer(item)
        }

        for(i in result.indices) {
            if(!pq.isEmpty()) {
                val item = pq.poll()
                result[i] = item.index
            }
        }

        return result
    }
}