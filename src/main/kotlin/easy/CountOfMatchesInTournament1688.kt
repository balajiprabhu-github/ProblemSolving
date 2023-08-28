package easy

fun main() {
    println(Solution1688().numberOfMatches(7))
    println(Solution1688().numberOfMatches(14))
}

private class Solution1688 {
    fun numberOfMatches(n: Int): Int {
        var matchesPlayed = 0
        var teams = n

        while (teams > 1) {
            if (teams % 2 == 0) {
                matchesPlayed += teams / 2
                teams /= 2
            } else {
                matchesPlayed += (teams - 1) / 2
                teams = (teams - 1) / 2 + 1
            }
        }

        return matchesPlayed
    }
}