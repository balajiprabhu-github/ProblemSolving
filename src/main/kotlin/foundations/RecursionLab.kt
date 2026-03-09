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

    /** Time Complexity
     * The number of operations depends on how many times we divide by 10.
     * Each division by 10 process roughly removes one digit from the number.
     * If a number has 'd' digits, it takes 'd' recursive calls to reach the base case.
     * The number of digits 'd' for a number 'n' is roughly log10(n).
     * Since each step requires O(1) operations (division, modulo, and addition),
     * Time Complexity is O(d) where d is the number of digits, which is equivalent to O(log n).
     */

    /** Space Complexity
     * Each recursive call adds a new frame to the call stack, waiting for the child call to finish.
     * Since there are 'd' recursive steps, the maximum depth of the call stack is 'd'.
     * Space Complexity is O(d) where d is the number of digits, which is equivalent to O(log n).
     */

    /**
     * sumDigits(123)
     * sumDigits(12) + 3
     * sumDigits(1) + 2 + 3
     * 1 + 2 + 3
     */
    fun sumDigits(n: Int): Int {
        if(n < 10) { 
            return n
        }
        return sumDigits(n/10) + (n%10)
    }

    /**
     * Problem 3: Power Function
     * Example: power(2, 3) -> 8
     */
    fun power(base: Int, exp: Int): Int {
        if(exp <= 0) {
            return 1
        } 
        return power(base,exp-1) * base
    }

    /** Time Complexity
     * The recursive function calls itself `exp` times, decrementing `exp` by 1 each time until it reaches 0.
     * Each recursive step performs a single constant O(1) multiplication operation.
     * Therefore, the Time Complexity is directly proportional to the exponent: O(exp).
     */

    /** Space Complexity
     * The recursive nature builds a call stack of depth `exp` before hitting the base case.
     * Each frame occupies memory on the call stack waiting for its child to return an integer.
     * Therefore, the Space Complexity is exactly O(exp).
     */

    /** Stack Trace Example:
     * power(2, 3)
     * power(2, 2) * 2
     * power(2, 1) * 2 * 2
     * power(2, 0) * 2 * 2 * 2
     * 1 * 2 * 2 * 2 
     */
}

fun main() {
    val lab = RecursionLab()
    println("Reverse 'hello': ${lab.reverse("hello")}")
    println("Sum digits 123: ${lab.sumDigits(123)}")
    println("2^3: ${lab.power(2, 3)}")
}
