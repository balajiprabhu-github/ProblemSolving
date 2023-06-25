package easy

fun main() {
    println(Solution1773().countMatches(
        listOf(
        listOf("phone","blue","pixel"),
        listOf("computer","silver","lenovo"),
        listOf("phone","gold","iphone")
        ),
        ruleKey = "color",
        ruleValue = "silver"
    )
    )

    println(Solution1773().countMatches(
        listOf(
            listOf("phone","blue","pixel"),
            listOf("computer","silver","lenovo"),
            listOf("phone","gold","iphone")
        ),
        ruleKey = "type",
        ruleValue = "phone"
    )
    )
}

private class Solution1773 {
    fun countMatches(items: List<List<String>>, ruleKey: String, ruleValue: String): Int {
        val ruleKeyMap = mapOf<String,Int>("type" to 0,"color" to 1,"name" to 2)
        return items.count {
            ruleValue == it[ruleKeyMap[ruleKey]!!]
        }
    }
}