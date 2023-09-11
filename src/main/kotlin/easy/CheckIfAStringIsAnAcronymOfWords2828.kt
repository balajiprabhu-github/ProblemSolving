package easy

fun main() {
    Solution2828().isAcronym(listOf("alice","bob","charlie"),"abc")
}

private class Solution2828 {
    fun isAcronym(words: List<String>, s: String): Boolean {

        if(words.size != s.length) {
            return false
        }

        for(i in words.indices) {
            if(words[i][0] != s[i]) {
                return false
            }
        }

        return true
    }
}