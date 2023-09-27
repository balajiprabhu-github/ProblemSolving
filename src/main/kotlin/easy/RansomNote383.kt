package easy

fun main() {
 println(Solution383().canConstruct("aa","ab"))
}

private class Solution383 {
    fun canConstruct(ransomNote: String, magazine: String): Boolean {
        var count = 0
        val rMap = ransomNote.toCharArray().toList().groupingBy { it }.eachCount()
        val mMap = magazine.toCharArray().toList().groupingBy { it }.eachCount()

        for(i in rMap.keys) {
            val rCount = rMap.getOrDefault(i,0)
            val mCount = mMap.getOrDefault(i,0)
            if(rCount <= mCount) {
                count += rCount.toInt()
            }
        }

        return ransomNote.length == count
    }
}