package easy

fun main() {
    println(Solution2418().sortPeople(arrayOf("Mary","John","Emma"), intArrayOf(180,165,170)).contentToString())
}

private class Solution2418 {
    fun sortPeople(names: Array<String>, heights: IntArray): Array<String> {

        return names.zip(heights.toTypedArray()).toList().sortedBy { (_,value) -> value }.map { it -> it.first }.reversed().toTypedArray()
    }
}