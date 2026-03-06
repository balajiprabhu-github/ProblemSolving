package foundations

/**
 * Phase 1, Part 2: Recursion Lab
 * 
 * Instructions:
 * Implement the following functions recursively.
 * After implementing, think about the Time and Space complexity for each.
 */

class RecursionLab {

    /**
     * Problem 1: Reverse a String
     * Example: "hello" -> "olleh"
     */

    
    /** Time Complexity
     * "hello" -> "olleh"
     * "o" -> copies o -> 1 operation
     * "ol" -> copies ol -> 2 operations
     * "oll" -> copies oll -> 3 operations
     * "olle" -> copies "olle" -> 4 operations
     * "olleh" -> copies "olleh" -> 5 operations
     * 
     * 1+2+3+4+5..N -> N(N+1) / 2 -> O(N^2)
     * 
     *  */ 

     /** Space Complexity
      * Space complexity is O(N) because the recursion goes N levels deep,
      * keeping N function calls on the call stack before returning.
      * Note: Creating a new `substring` at each step also takes up O(N) extra space
      * string memory per frame, totaling O(N^2) memory allocated. 
      * But for basic recursion tracing, focus on the O(N) stack frames.
      */


      /**
       * reverse("hello")
       * reverse("ello") + "h"
       * reverse("llo") + "e" + "h"
       * reverse("lo") + "l" + "e" + "h"
       * reverse("o") + "l" +"l" + "e" + "h"
       * reverse("") + "o" + "l" + "l" + "e" + "h"
       */

    fun reverse(s: String): String {
        if(s.isEmpty()) return ""
        return reverse(s.substring(1)) + s[0]
    }

    /**
     * Problem 2: Sum of Digits
     * Example: 123 -> 1 + 2 + 3 = 6
     */
    fun sumDigits(n: Int): Int {
        // TODO: Implement recursively
        return 0
    }

    /**
     * Problem 3: Power Function
     * Example: power(2, 3) -> 8
     */
    fun power(base: Int, exp: Int): Int {
        // TODO: Implement recursively
        return 0
    }
}

fun main() {
    val lab = RecursionLab()
    println("Reverse 'hello': ${lab.reverse("hello")}")
    println("Sum digits 123: ${lab.sumDigits(123)}")
    println("2^3: ${lab.power(2, 3)}")
}
