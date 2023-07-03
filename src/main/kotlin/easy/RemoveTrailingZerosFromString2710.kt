package easy

fun main() {
    println(Solution2710().removeTrailingZeros("51230100"))
    println(Solution2710().removeTrailingZeros("123"))
}

private class Solution2710 {
    fun removeTrailingZeros(num: String): String {
        var end = num.length

        for(i in num.indices.reversed()){
            if(num[i] == '0'){
                end--
            }else {
                break
            }
        }

        return num.substring(0,end)
    }
}