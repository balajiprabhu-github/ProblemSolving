package foundations

import kotlin.math.max
import kotlin.math.min

/**
 * Phase 2, Part 2: Sliding Window Lab
 *
 * Sliding window is a technique for reducing nested loops into a single pass
 * by maintaining a "window" — a contiguous subarray or substring — and
 * expanding or shrinking it based on a condition.
 *
 * ═══════════════════════════════════════════════════════════
 * THE 3 PATTERNS
 * ═══════════════════════════════════════════════════════════
 *
 * Pattern 1 — FIXED SIZE WINDOW
 *   Window size k is given. Slide one step at a time.
 *   When to use: "find max/min/avg of every subarray of size k"
 *
 * Pattern 2 — VARIABLE SIZE WINDOW
 *   Window expands and shrinks based on a constraint.
 *   When to use: "longest/shortest subarray/substring that satisfies X"
 *
 * Pattern 3 — WINDOW WITH FREQUENCY MAP
 *   Variable window + HashMap/IntArray to track character counts.
 *   When to use: anagram matching, "at most k distinct chars", permutation check
 * ═══════════════════════════════════════════════════════════
 *
 * Instructions:
 *   For each problem:
 *   1. Trace through the example by hand BEFORE writing code
 *   2. Implement the brute force first, then the sliding window solution
 *   3. Fill in Time and Space complexity with step-by-step reasoning
 */

class SlidingWindowLab {

    // ═══════════════════════════════════════════════════════════
    // PATTERN 1: FIXED SIZE WINDOW
    // ═══════════════════════════════════════════════════════════

    /**
     * Problem 1: Maximum Average Subarray I (LeetCode 643)
     *
     * You are given an integer array nums consisting of n elements, and an integer k.
     * Find a contiguous subarray whose length is equal to k that has the maximum average value
     * and return this value. Any answer with a calculation error less than 10^-5 will be accepted.
     *
     * Example 1:
     *   Input:  nums = [1, 12, -5, -6, 50, 3], k = 4
     *   Output: 12.75000
     *   Explanation: Maximum average is (12 - 5 - 6 + 50) / 4 = 51 / 4 = 12.75
     *
     * Example 2:
     *   Input:  nums = [5], k = 1
     *   Output: 5.00000
     *
     * Constraints:
     *   - n == nums.length
     *   - 1 <= k <= n <= 10^5
     *   - -10^4 <= nums[i] <= 10^4
     */

    fun findMaxAverageBrute(nums: IntArray, k: Int): Double {
        var maxSum = Double.MIN_VALUE

        for (i in 0..nums.size - k) {
            var sum = nums[i].toDouble()
            for (j in i + 1 until i + k) {
                sum += nums[j].toDouble()
            }
            maxSum = max((sum / k), maxSum)
        }
        return maxSum
    }

    fun findMaxAverage(nums: IntArray, k: Int): Double {
        var left = 0
        var right = k
        var windowSum = 0.0

        for (i in 0 until k) {
            windowSum += nums[i]
        }

        var maxSum = windowSum

        while (right < nums.size) {
            windowSum += nums[right++]
            windowSum -= nums[left++]
            maxSum = max(windowSum, maxSum)
        }

        return maxSum / k
    }

    /** Time Complexity: O(n) No nested loops **/
    /** Space Complexity: O(1) No extra space **/


    // ═══════════════════════════════════════════════════════════
    // PATTERN 2: VARIABLE SIZE WINDOW
    // ═══════════════════════════════════════════════════════════

    /**
     * Problem 2: Minimum Size Subarray Sum (LeetCode 209)
     *
     * Given an array of positive integers nums and a positive integer target,
     * return the minimal length of a subarray whose sum is greater than or equal to target.
     * If there is no such subarray, return 0 instead.
     *
     * Example 1:
     *   Input:  target = 7, nums = [2, 3, 1, 2, 4, 3]
     *   Output: 2
     *   Explanation: The subarray [4, 3] has the minimal length under the problem constraint.
     *
     * Example 2:
     *   Input:  target = 4, nums = [1, 4, 4]
     *   Output: 1
     *
     * Example 3:
     *   Input:  target = 11, nums = [1, 1, 1, 1, 1, 1, 1, 1]
     *   Output: 0
     *
     * Constraints:
     *   - 1 <= target <= 10^9
     *   - 1 <= nums.length <= 10^5
     *   - 1 <= nums[i] <= 10^4
     */

    fun minSubArrayLenBrute(target: Int, nums: IntArray): Int {
        var minLen = Int.MAX_VALUE
        for(i in nums.indices) {
            var sum = 0
            for(j in i until nums.size) {
                sum += nums[j]
                if(sum >= target){
                    minLen = min(minLen,j-i+1)
                    break
                }
            }
        }
        return if(minLen == Int.MAX_VALUE) 0 else minLen
    }

    fun minSubArrayLen(target: Int, nums: IntArray): Int {
        var minLength = Int.MAX_VALUE
        var left = 0
        var sum = 0
        for(right in nums.indices) {
            sum += nums[right]
            while(sum >= target) {
                minLength = min(minLength,right - left + 1)
                sum -= nums[left++]
            }
        }
        return if(minLength == Int.MAX_VALUE) 0 else minLength
    }

    /** Time Complexity: O(n) Each element is added (right) and removed (left) at most once — amortized O(2n) = O(n) */
    /** Space Complexity: O(1) No extra space */


    /**
     * Problem 3: Longest Substring Without Repeating Characters (LeetCode 3)
     *
     * Given a string s, find the length of the longest substring without duplicate characters.
     *
     * Example 1:
     *   Input:  s = "abcabcbb"
     *   Output: 3
     *   Explanation: The answer is "abc", with the length of 3.
     *
     * Example 2:
     *   Input:  s = "bbbbb"
     *   Output: 1
     *   Explanation: The answer is "b", with the length of 1.
     *
     * Example 3:
     *   Input:  s = "pwwkew"
     *   Output: 3
     *   Explanation: The answer is "wke", with the length of 3.
     *
     * Constraints:
     *   - 0 <= s.length <= 5 * 10^4
     *   - s consists of English letters, digits, symbols and spaces.
     */

    fun lengthOfLongestSubstringBrute(s: String): Int {
        // TODO
        return 0
    }

    fun lengthOfLongestSubstring(s: String): Int {
        // TODO
        return 0
    }

    /** Time Complexity: TODO */
    /** Space Complexity: TODO */


    /**
     * Problem 4: Longest Repeating Character Replacement (LeetCode 424)
     *
     * You are given a string s and an integer k.
     * You can choose any character of the string and change it to any other uppercase English character.
     * You can perform this operation at most k times.
     * Return the length of the longest substring containing the same letter you can get
     * after performing the above operations.
     *
     * Example 1:
     *   Input:  s = "ABAB", k = 2
     *   Output: 4
     *   Explanation: Replace the two 'A's with two 'B's or vice versa.
     *
     * Example 2:
     *   Input:  s = "AABABBA", k = 1
     *   Output: 4
     *   Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
     *                The substring "BBBB" has the longest repeating letters, which is 4.
     *
     * Constraints:
     *   - 1 <= s.length <= 10^5
     *   - s consists of only uppercase English letters.
     *   - 0 <= k <= s.length
     */

    fun characterReplacementBrute(s: String, k: Int): Int {
        // TODO
        return 0
    }

    fun characterReplacement(s: String, k: Int): Int {
        // TODO
        return 0
    }

    /** Time Complexity: TODO */
    /** Space Complexity: TODO */


    // ═══════════════════════════════════════════════════════════
    // PATTERN 3: WINDOW WITH FREQUENCY MAP
    // ═══════════════════════════════════════════════════════════

    /**
     * Problem 5: Permutation in String (LeetCode 567)
     *
     * Given two strings s1 and s2, return true if s2 contains a permutation of s1,
     * or false otherwise.
     * In other words, return true if one of s1's permutations is a substring of s2.
     *
     * Example 1:
     *   Input:  s1 = "ab", s2 = "eidbaooo"
     *   Output: true
     *   Explanation: s2 contains one permutation of s1 ("ba").
     *
     * Example 2:
     *   Input:  s1 = "ab", s2 = "eidboaoo"
     *   Output: false
     *
     * Constraints:
     *   - 1 <= s1.length, s2.length <= 10^4
     *   - s1 and s2 consist of lowercase English letters.
     */

    fun checkInclusionBrute(s1: String, s2: String): Boolean {
        // TODO
        return false
    }

    fun checkInclusion(s1: String, s2: String): Boolean {
        // TODO
        return false
    }

    /** Time Complexity: TODO */
    /** Space Complexity: TODO */


    /**
     * Problem 6: Minimum Window Substring (LeetCode 76)
     *
     * Given two strings s and t of lengths m and n respectively,
     * return the minimum window substring of s such that every character in t
     * (including duplicates) is included in the window.
     * If there is no such substring, return the empty string "".
     *
     * Example 1:
     *   Input:  s = "ADOBECODEBANC", t = "ABC"
     *   Output: "BANC"
     *   Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
     *
     * Example 2:
     *   Input:  s = "a", t = "a"
     *   Output: "a"
     *
     * Example 3:
     *   Input:  s = "a", t = "aa"
     *   Output: ""
     *   Explanation: Both 'a's from t must be included in the window.
     *                Since the largest window of s only has one 'a', return "".
     *
     * Constraints:
     *   - m == s.length, n == t.length
     *   - 1 <= m, n <= 10^5
     *   - s and t consist of uppercase and lowercase English letters.
     */

    fun minWindowBrute(s: String, t: String): String {
        // TODO
        return ""
    }

    fun minWindow(s: String, t: String): String {
        // TODO
        return ""
    }

    /** Time Complexity: TODO */
    /** Space Complexity: TODO */
}

fun main() {
    val lab = SlidingWindowLab()
    println("Max avg [1,12,-5,-6,50,3] k=4: ${lab.findMaxAverageBrute(intArrayOf(1, 12, -5, -6, 50, 3), 4)}")
    println("Min subarray len target=7 [2,3,1,2,4,3]: ${lab.minSubArrayLen(7, intArrayOf(2, 3, 1, 2, 4, 3))}")
    println("Longest no-repeat 'abcabcbb': ${lab.lengthOfLongestSubstring("abcabcbb")}")
    println("Char replacement 'ABAB' k=2: ${lab.characterReplacement("ABAB", 2)}")
    println("Permutation in string s1='ab' s2='eidbaooo': ${lab.checkInclusion("ab", "eidbaooo")}")
    println("Min window s='ADOBECODEBANC' t='ABC': ${lab.minWindow("ADOBECODEBANC", "ABC")}")
}