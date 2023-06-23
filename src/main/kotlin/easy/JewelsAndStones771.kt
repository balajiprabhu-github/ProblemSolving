package easy

fun main() {
    println(Solution771().numJewelsInStones("aA","aAAbbbb"))
}

private class Solution771 {
    fun numJewelsInStones(jewels: String, stones: String): Int {
        var result = 0
        val map = mutableMapOf<Char,Int>()

        for(i in stones.indices) {
            map[stones[i]] = map.getOrDefault(stones[i],0)+1
        }

        for(i in jewels.indices) {
            if(map.containsKey(jewels[i])){
                result += map[jewels[i]]!!
            }
        }

        return result

    }
}