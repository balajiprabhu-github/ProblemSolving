package medium

fun main() {
    println(Solution49().groupAnagrams(arrayOf("eat","tea","tan","ate","nat","bat")))
    println(Solution49().groupAnagrams(arrayOf("")))
    println(Solution49().groupAnagrams(arrayOf("a")))
}

private class Solution49 {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val sortedMap = mutableMapOf<String,MutableList<String>>()
        for (str in strs) {
            val key = str.toCharArray().sorted().joinToString("")
            if (sortedMap.containsKey(key)) {
                val list : MutableList<String> = sortedMap.getOrDefault(key, mutableListOf(str))
                list.add(str)
                sortedMap[key] = list
            } else {
                sortedMap[key] = mutableListOf(str)
            }
        }
        return sortedMap.values.toList()
    }
}