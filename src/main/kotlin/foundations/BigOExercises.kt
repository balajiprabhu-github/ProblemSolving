package foundations

/**
 * Phase 1, Part 1: Big-O Analysis Exercises
 *
 * For each function below:
 *   1. Analyze the TIME complexity — explain your reasoning
 *   2. Analyze the SPACE complexity — don't forget the call stack for recursion
 *   3. Write your answers in the TODOs
 */

// ============================================================
// Exercise 1: Simple Loop
// ============================================================
fun containsTarget(arr: IntArray, target: Int): Boolean {
    for (num in arr) {
        if (num == target) return true
    }
    return false
}
// Time = O(n) where n = arr.size  Reason: In the worst-case, the loop runs through the entire array n times.
// Space = O(1)  Reason: No extra variables are created that scale with input size.


// ============================================================
// Exercise 2: Nested Loops (Watch Out)
// ============================================================
fun printPairs(n: Int) {
    for (i in 0 until n) {
        for (j in i + 1 until n) {
            println("$i, $j")
        }
    }
}
// Time = O(n^2)  Reason: Sum of (n-1) + (n-2) + ... + 1 = n(n-1)/2 which simplifies to O(n^2).
// Space = O(1)  Reason: Only loop counters are used.


// ============================================================
// Exercise 3: Log Pattern 
// ============================================================
fun mystery(n: Int): Int {
    var count = 0
    var i = n
    while (i > 1) {
        i /= 2
        count++
    }
    return count
}
// Time = O(log n)   Reason: The problem space is halved in each step (i /= 2).
// Space = O(1)  Reason: Only a few local variables are used.


// ============================================================
// Exercise 4: String Building (Tricky!)
// ============================================================
fun buildString(n: Int): String {
    var result = ""
    for (i in 0 until n) {
        result += "x"  // What happens here in JVM? - ASCII value of x will be increment until the loop finishes
    }
    return result
}
// Time = O(n^2)   Reason: String immutability. result += "x" copies the existing string of length i at each step (0+1+2...+n-1 = O(n^2)).
// Space = O(n)  Reason: Final result string size is proportional to n.
// HINT: Strings in Kotlin/JVM are immutable. What does += actually do?


// ============================================================
// Exercise 5: Two Arrays
// ============================================================
fun intersect(a: IntArray, b: IntArray): List<Int> {
    val result = mutableListOf<Int>()
    for (x in a) {
        for (y in b) {
            if (x == y) {
                result.add(x)
                break
            }
        }
    }
    return result
}
// Time = O(a * b)   Reason: Nested loops over different inputs (a = a.size, b = b.size).
// Space = O(min(a, b))  Reason: The result list can at most contain the number of elements in the smaller array.


// ============================================================
// Exercise 6: Recursive Fibonacci
// ============================================================
fun fib(n: Int): Int {
    if (n <= 1) return n
    return fib(n - 1) + fib(n - 2)
}
// Time = O(2^n)   Reason: The recursion tree branches into 2 at each level, and depth is n (Fibonacci tree).
// Space = O(n)  Reason: The maximum depth of the call stack at any point is n.
// HINT: Draw the recursion tree for fib(5). Count the nodes.
//       For space, think about the MAXIMUM depth of the call stack at any moment.
