package easy

fun main() {
    println(Solution242().isAnagram("anagram","nagaram"))
    println(Solution242().isAnagram("rat","car"))
    println(Solution242().isAnagram("xaaddy","xbbccy"))
}
private class Solution242 {
    fun isAnagram(s: String, t: String): Boolean {

        val sMap = HashMap<Char,Int>()
        val tMap = HashMap<Char,Int>()

        for (c in s){
            if (sMap.contains(c)) {
                var temp = sMap[c] ?:0
                temp+=1
                sMap[c] = temp
            } else {
                sMap[c] = 1
            }
        }

        for (c in t){
            if (tMap.contains(c)) {
                var temp = tMap[c] ?:0
                temp+=1
                tMap[c] = temp
            } else {
                tMap[c] = 1
            }
        }

        return tMap == sMap
    }
}