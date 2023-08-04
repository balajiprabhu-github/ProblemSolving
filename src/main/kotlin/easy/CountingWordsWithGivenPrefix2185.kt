package easy

fun main() {
    println(Solution2185().prefixCount(arrayOf("pay","attention","practice","attend"),"at"))
}


private class Solution2185 {
    fun prefixCount(words: Array<String>, pref: String): Int {
        var result = 0
        for(word in words) {

            var counter = 0

            if(word.length >= pref.length) {
                for(i in pref.indices) {
                    if(word[i] == pref[i]) {
                        counter++
                    }
                }

                if(counter == pref.length){
                    result++
                }
            }

        }
        return result
    }
}