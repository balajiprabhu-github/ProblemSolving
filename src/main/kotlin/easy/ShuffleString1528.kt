package easy

fun main(){
    println(Solution1528().restoreString("codeleet", intArrayOf(4,5,6,7,0,2,1,3)))
}

private class Solution1528 {
    fun restoreString(s: String, indices: IntArray): String {

        val temp = s.toCharArray()
        val result = StringBuilder("")

        for(i in indices.indices) {
            temp[indices[i]] = s[i]
        }

        for (c in temp){
            result.append(c)
        }

        return result.toString()
    }
}