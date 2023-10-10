package easy

fun main() {
    println(Solution290().wordPattern("abba","dog cat cat dog"))
}

private class Solution290 {
    fun wordPattern(pattern: String, s: String): Boolean {
        val words = s.split(" ")

        if(words.size != pattern.length) return false

        val map = mutableMapOf<Char,String>()

        for(i in pattern.indices) {
            if(!map.values.contains(words[i])) {
                map[pattern[i]] = words[i]
            }
        }

        for(i in pattern.indices) {
            val word = map.getOrDefault(pattern[i],'_')
            if(words[i] != word) {
                return false
            }
        }

        return true
    }
}