package foundations

import kotlin.math.max
import kotlin.math.min

/**
 * Phase 2, Part 1: Two Pointers Lab
 *
 * Two pointers is not a single trick — it is a family of patterns.
 * Master the mental model for each pattern, and any new problem becomes recognizable.
 *
 * ═══════════════════════════════════════════════════════════
 * THE 4 PATTERNS
 * ═══════════════════════════════════════════════════════════
 *
 * Pattern 1 — OPPOSITE ENDS (Converging)
 *   left = 0, right = n-1, move toward each other
 *   When to use: sorted array, palindrome, find pair with constraint
 *
 * Pattern 2 — FAST / SLOW (Same Direction)
 *   slow tracks a "write" position, fast reads ahead
 *   When to use: in-place removal, deduplication, partition
 *
 * Pattern 3 — TWO SEQUENCES
 *   one pointer per array/string, both move forward independently
 *   When to use: merging, subsequence check, comparing two streams
 *
 * Pattern 4 — THREE POINTERS (Partition / kSum)
 *   extends Pattern 1 or 2 with a third pointer
 *   When to use: Dutch National Flag, 3Sum, 4Sum
 * ═══════════════════════════════════════════════════════════
 *
 * Instructions:
 *   For each problem:
 *   1. Trace through the example by hand BEFORE writing code
 *   2. Implement the solution
 *   3. Fill in Time and Space complexity with step-by-step reasoning
 */

class TwoPointersLab {

    // ═══════════════════════════════════════════════════════════
    // PATTERN 1: OPPOSITE ENDS
    // Template:
    //   var left = 0; var right = s.lastIndex
    //   while (left < right) {
    //       if (condition) { ... left++; right-- }
    //       else if (...) left++
    //       else right--
    //   }
    // ═══════════════════════════════════════════════════════════

    /**
     * Problem 1a: Valid Palindrome (LeetCode 125)
     *
     * A phrase is a palindrome if it reads the same forward and backward
     * after keeping only alphanumeric characters and ignoring case.
     *
     * Example: "A man, a plan, a canal: Panama" -> true
     * Example: "race a car" -> false
     *
     * Trace by hand first:
     *   s = "A man, a plan, a canal: Panama"
     *   left=0 ('A'), right=29 ('a') — both alphanumeric, same letter ignoring case -> move both
     *   left=1 (' '), — not alphanumeric -> skip left only
     *   ... keep going until left >= right
     *
     * Hint: use Char.isLetterOrDigit() and Char.lowercaseChar()
     */

    fun isPalindromeBrute(s: String): Boolean {
        val filteredString = StringBuilder()

        for (c in s) {
            if (c in '0'..'9' || c in 'A'..'Z' || c in 'a'..'z') {
                filteredString.append(c.lowercaseChar())
            }
        }

        val a = filteredString.toString()
        val b = filteredString.toString().reversed()

        for (i in a.indices) {
            if (a[i] != b[i]) {
                return false
            }
        }

        return true
    }
    // Time: O(n) — one pass to filter, one to reverse, one to compare
    // Space: O(n) — filteredString + a + b each up to n chars

    fun isPalindrome(s: String): Boolean {
        var left = 0
        var right = s.length - 1

        while (left < right) {
            when {
                !s[left].isLetterOrDigit() -> left++
                !s[right].isLetterOrDigit() -> right--
                s[left].lowercaseChar() != s[right].lowercaseChar() -> return false
                else -> {
                    left++
                    right--
                }
            }
        }
        return true
    }
    // Time: O(n) -  each character is visited at most once by either pointer
    // Space: O(1) - only two integer pointers, no extra allocation

    /**
     * Problem 1b: Two Sum II — Input Array Is Sorted (LeetCode 167)
     *
     * Given a 1-indexed sorted array, find two numbers that add to target.
     * Return their 1-based indices. Exactly one solution guaranteed.
     *
     * Example: numbers = [2,7,11,15], target = 9 -> [1,2]
     *
     * Trace by hand first:
     *   left=0 (2), right=3 (15) -> sum=17 > 9 -> move right left
     *   left=0 (2), right=2 (11) -> sum=13 > 9 -> move right left
     *   left=0 (2), right=1 (7)  -> sum=9 == target -> return [1,2]
     *
     * Key insight: why does this work on a sorted array?
     *   If sum > target, the only way to reduce it is to move right pointer left.
     *   If sum < target, the only way to increase it is to move left pointer right.
     *   Every move eliminates an entire row/column of possibilities.
     */
    fun twoSumIIBruteForce(numbers: IntArray, target: Int): IntArray {
        for(i in numbers.indices) {
            for(j in i+1 until numbers.size) {
                val sum = numbers[i] + numbers[j]
                if(sum == target) {
                    return intArrayOf(i+1,j+1)
                }
            }
        }
        return intArrayOf()
    }

    // Time: O(n^2) - here we are using nested loop, looks like sum of n numbers -> n(n+1)/2 -> n^2
    // Space: O(1) - Apart from local variables (const space), No extra space is used. Result intArray of const size 2

    fun twoSumII(numbers: IntArray, target: Int): IntArray {
        var left = 0
        var right = numbers.size-1

        while(left < right) {
            val sum = numbers[left] + numbers[right]
            when {
                sum > target -> right--
                sum < target -> left++
                else -> {
                    // sum == target
                    return intArrayOf(left+1, right+1)
                }
            }
        }

        return intArrayOf()
    }
    // Time: O(n) - iterate through each index in worst case
    // Space: O(1) - Apart from local variables (const space), No extra space is used. Result intArray of const size 2

    /**
     * Problem 1c: Container With Most Water (LeetCode 11)
     *
     * Given heights of vertical lines, find two lines that together with x-axis
     * form a container that holds the most water.
     *
     * Example: height = [1,8,6,2,5,4,8,3,7] -> 49
     *
     * Trace by hand first:
     *   left=0 (h=1), right=8 (h=7) -> area = min(1,7) * 8 = 8 -> move the shorter side
     *   left=1 (h=8), right=8 (h=7) -> area = min(8,7) * 7 = 49 -> move shorter (right)
     *   left=1 (h=8), right=7 (h=3) -> area = min(8,3) * 6 = 18 -> move shorter (right)
     *   ... continue
     *
     * Key insight: why move the shorter side?
     *   Width only decreases as we move inward. To have any chance of more area,
     *   we need a taller side. Moving the taller side can only hurt (width down, height won't go up).
     *   Moving the shorter side might find a taller line -> possible improvement.
     */
    fun maxWaterBruteForce(height: IntArray): Int {
        var result = 0

        for( i in height.indices) {
            for( j in i+1 until height.size) {
                result = max(min(height[i],height[j]) * (j - i), result)
            }
        }

        return result
    }
    // Time: O(n^2) - We have nested loops that will run for sum of n numbers n(n+1)/2  -> n^2 (ignoring const) -> O(n^2)
    // Space: O(1) - No extra space has been used unless the result variable which is a const

    fun maxWater(height: IntArray): Int {
        var result  = 0
        var left = 0
        var right = height.size-1

        while(left < right) {
            val area = min(height[left],height[right]) * (right - left)
            when {
                height[left] < height[right] -> left++
                height[left] > height[right] -> right--
                else -> {
                    left++
                }
            }

            result = max(result, area)
        }

        return result
    }

    // Time: O(n) - the while loop will iterate over each index in the array so if there n items in array TC will O(n)
    // Space: O(1) - No extra space has been used unless the result, left and right variables which are const

    /**
     * Problem 1d: Trapping Rain Water (LeetCode 42) [Hard]
     *
     * Given elevation map, compute how much water can be trapped after rain.
     *
     * Example: height = [0,1,0,2,1,0,1,3,2,1,2,1] -> 6
     *
     * Key insight: water at index i = min(maxLeft[i], maxRight[i]) - height[i]
     * Two-pointer insight: instead of pre-computing arrays, track running max from each side.
     *   At each step, the side with the smaller max is the bottleneck.
     *   Process that side: water += maxSide - height[pointer], then move that pointer.
     *
     * Trace by hand first with [0,1,0,2,1,0,1,3,2,1,2,1]:
     *   left=0, right=11, leftMax=0, rightMax=0
     *   height[left]=0 <= height[right]=1 -> process left
     *     leftMax = max(0,0)=0, water += 0-0=0, left++
     *   left=1, right=11, leftMax=0, rightMax=0
     *   height[left]=1 > height[right]=1? No -> process left
     *     leftMax = max(0,1)=1, water += 1-1=0, left++
     *   ... continue until left >= right
     */
    fun trapBruteForce(height: IntArray): Int {

        var result = 0

        for(i in height.indices) {

            var leftMax = 0
            var rightMax = 0

            for( left in i-1 downTo 0) {
                if(height[left] > leftMax) {
                    leftMax = height[left]
                }
            }

            for( right in i+1 until height.size) {
                if(height[right] > rightMax) {
                    rightMax = height[right]
                }
            }

            result += maxOf(0,min(leftMax, rightMax) - height[i])
        }

        return result
    }
    // Time: O(n^2) -> for each index i, we are iterate two inner loops combined into (n-1) so n(n-1) -> n^2 ignoring constant.
    // Space: O(1) -> no extra space have we used other than constant variables


    fun trap(height: IntArray): Int {
        var left = 0
        var right = height.size-1

        var leftMax = 0
        var rightMax = 0

        var water = 0

        while(left <= right) {
            if(height[left] <= height[right]) {
                leftMax = max(leftMax, height[left])
                water += leftMax - height[left]
                left++
            } else {
                rightMax = max(rightMax, height[right])
                water += rightMax - height[right]
                right--
            }
        }
        return water
    }

    // Time: O(n) -> we are iterating each index from both the ends. So n times loop will execute
    // Space: O(1) -> No extra space has used here apart from constant variables


    // ═══════════════════════════════════════════════════════════
    // PATTERN 2: FAST / SLOW (SAME DIRECTION)
    // Template:
    //   var slow = 0
    //   for (fast in ...) {
    //       if (condition to keep) { nums[slow] = nums[fast]; slow++ }
    //   }
    //   return slow  // slow = length of valid portion
    // ═══════════════════════════════════════════════════════════

    /**
     * Problem 2a: Remove Duplicates from Sorted Array (LeetCode 26)
     *
     * In-place: remove duplicates from sorted array. Return count of unique elements.
     * The first k elements of nums should hold the result (order preserved).
     *
     * Example: nums = [1,1,2] -> 2, nums = [1,2,_]
     * Example: nums = [0,0,1,1,1,2,2,3,3,4] -> 5, nums = [0,1,2,3,4,_,_,_,_,_]
     *
     * Trace by hand first:
     *   nums = [0,0,1,1,1,2,2,3,3,4]
     *   slow=0
     *   fast=0: nums[0]=0, first element always keep -> slow=1
     *   fast=1: nums[1]=0 == nums[0]=0 -> duplicate, skip
     *   fast=2: nums[2]=1 != nums[slow-1]=0 -> keep: nums[slow]=1, slow=2
     *   fast=3: nums[3]=1 == nums[slow-1]=1 -> duplicate, skip
     *   fast=4: nums[4]=1 == nums[slow-1]=1 -> duplicate, skip
     *   fast=5: nums[5]=2 != nums[slow-1]=1 -> keep: nums[slow]=2, slow=3
     *   ... result: slow=5
     */
    fun removeDuplicates(nums: IntArray): Int {
        TODO("Implement using fast/slow two pointer")
    }
    // Time: O(?)
    // Space: O(?)

    /**
     * Problem 2b: Move Zeroes (LeetCode 283)
     *
     * Move all zeroes to the end while maintaining relative order of non-zero elements.
     * Must do in-place.
     *
     * Example: nums = [0,1,0,3,12] -> [1,3,12,0,0]
     *
     * Trace by hand first:
     *   slow=0
     *   fast=0: nums[0]=0  -> zero, skip
     *   fast=1: nums[1]=1  -> non-zero: swap nums[slow] and nums[fast] -> slow=1
     *   fast=2: nums[2]=0  -> zero, skip
     *   fast=3: nums[3]=3  -> non-zero: swap nums[slow] and nums[fast] -> slow=2
     *   fast=4: nums[4]=12 -> non-zero: swap nums[slow] and nums[fast] -> slow=3
     *   result: [1,3,12,0,0]
     *
     * Why swap instead of just write?
     *   Swap preserves the zero that was at slow's position — it gets pushed forward.
     */
    fun moveZeroes(nums: IntArray): Unit {
        TODO("Implement using fast/slow two pointer")
    }
    // Time: O(?)
    // Space: O(?)

    /**
     * Problem 2c: Find the Duplicate Number (LeetCode 287) [Floyd's Cycle]
     *
     * Given n+1 integers in range [1,n], find the duplicate. O(1) space, no modify array.
     *
     * Example: nums = [1,3,4,2,2] -> 2
     * Example: nums = [3,1,3,4,2] -> 3
     *
     * Key insight: treat array as a linked list where nums[i] points to index nums[i].
     *   A duplicate means two indices point to the same next index -> cycle exists.
     *   Use Floyd's algorithm: fast moves 2 steps, slow moves 1 step.
     *   Phase 1: detect cycle (fast == slow inside cycle)
     *   Phase 2: find cycle entrance (reset one pointer to head, both move 1 step)
     *
     * Trace by hand with [1,3,4,2,2]:
     *   Treat as: 0->1->3->2->4->2->4->... (cycle at 2)
     *   Phase 1:
     *     slow=0->1, fast=0->1->3
     *     slow=1->3, fast=3->2->4
     *     slow=3->2, fast=4->2->4  -- wait, let me retrace...
     *     slow=nums[slow], fast=nums[nums[fast]]
     *     slow=nums[0]=1, fast=nums[nums[0]]=nums[1]=3
     *     slow=nums[1]=3, fast=nums[nums[3]]=nums[2]=4
     *     slow=nums[3]=2, fast=nums[nums[4]]=nums[2]=4
     *     slow=nums[2]=4, fast=nums[nums[4]]=nums[2]=4 -> slow==fast=4
     *   Phase 2: reset slow=0, fast stays at 4
     *     slow=nums[0]=1, fast=nums[4]=2
     *     slow=nums[1]=3, fast=nums[2]=4
     *     slow=nums[3]=2, fast=nums[4]=2 -> slow==fast=2 -> duplicate is 2 ✓
     */
    fun findDuplicate(nums: IntArray): Int {
        TODO("Implement using Floyd's cycle detection (fast/slow pointers on values)")
    }
    // Time: O(?)
    // Space: O(?)


    // ═══════════════════════════════════════════════════════════
    // PATTERN 3: TWO SEQUENCES
    // Template:
    //   var i = 0; var j = 0
    //   while (i < a.size && j < b.size) {
    //       if (match) { i++; j++ }
    //       else { advance whichever makes sense }
    //   }
    // ═══════════════════════════════════════════════════════════

    /**
     * Problem 3a: Is Subsequence (LeetCode 392)
     *
     * Return true if s is a subsequence of t.
     * Subsequence: characters of s appear in t in order (not necessarily contiguous).
     *
     * Example: s = "ace", t = "abcde" -> true
     * Example: s = "aec", t = "abcde" -> false
     *
     * Trace by hand first:
     *   s="ace", t="abcde"
     *   i=0('a'), j=0('a') -> match: i=1, j=1
     *   i=1('c'), j=1('b') -> no match: j=2
     *   i=1('c'), j=2('c') -> match: i=2, j=3
     *   i=2('e'), j=3('d') -> no match: j=4
     *   i=2('e'), j=4('e') -> match: i=3, j=5
     *   i==s.length -> return true
     */
    fun isSubsequence(s: String, t: String): Boolean {
        TODO("Implement using two-sequence two pointer")
    }
    // Time: O(?)
    // Space: O(?)

    /**
     * Problem 3b: Merge Sorted Array (LeetCode 88)
     *
     * Merge nums2 into nums1 in-place. nums1 has extra space at end for nums2.
     * m = valid elements in nums1, n = valid elements in nums2.
     *
     * Example: nums1=[1,2,3,0,0,0] m=3, nums2=[2,5,6] n=3 -> [1,2,2,3,5,6]
     *
     * Key insight: merge from the BACK to avoid overwriting unread elements.
     *   p1 = m-1 (last valid in nums1)
     *   p2 = n-1 (last in nums2)
     *   p  = m+n-1 (last position in nums1)
     *   Place the larger of nums1[p1] vs nums2[p2] at position p, then move that pointer.
     *
     * Trace by hand first:
     *   p1=2(3), p2=2(6), p=5 -> 6>3: nums1[5]=6, p2=1, p=4
     *   p1=2(3), p2=1(5), p=4 -> 5>3: nums1[4]=5, p2=0, p=3
     *   p1=2(3), p2=0(2), p=3 -> 3>2: nums1[3]=3, p1=1, p=2
     *   p1=1(2), p2=0(2), p=2 -> 2>=2: nums1[2]=2, p1=0, p=1
     *   p1=0(1), p2=0(2), p=1 -> 2>1: nums1[1]=2, p2=-1, p=0
     *   p2 exhausted -> done. nums1=[1,2,2,3,5,6] ✓
     */
    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
        TODO("Implement using reverse two-sequence merge")
    }
    // Time: O(?)
    // Space: O(?)

    /**
     * Problem 3c: Backspace String Compare (LeetCode 844)
     *
     * Given strings s and t where '#' means backspace, check if they are equal.
     * Solve in O(1) space (no building new strings).
     *
     * Example: s = "ab#c", t = "ad#c" -> true  (both become "ac")
     * Example: s = "ab##", t = "c#d#" -> true  (both become "")
     *
     * Key insight: process from RIGHT to LEFT. When you see '#', skip the next real char.
     *   Track a skip counter. If skip > 0 and current char is not '#', consume skip.
     *   Compare characters only when both pointers land on a real character.
     *
     * Trace by hand first:
     *   s="ab#c", t="ad#c"
     *   i=3('c'),j=3('c'), skip_s=0,skip_t=0 -> both real, 'c'=='c' -> i=2,j=2
     *   i=2('#'),j=2('#') -> both backspace: skip_s=1, skip_t=1 -> i=1,j=1
     *   i=1('b'),j=1('d') -> skip_s=1>0: consume skip, skip_s=0, i=0
     *                         skip_t=1>0: consume skip, skip_t=0, j=0
     *   i=0('a'),j=0('a') -> both real, 'a'=='a' -> i=-1, j=-1
     *   both exhausted -> true ✓
     */
    fun backspaceCompare(s: String, t: String): Boolean {
        TODO("Implement using right-to-left two-sequence pointer")
    }
    // Time: O(?)
    // Space: O(?)


    // ═══════════════════════════════════════════════════════════
    // PATTERN 4: THREE POINTERS (Partition / kSum)
    // ═══════════════════════════════════════════════════════════

    /**
     * Problem 4a: Sort Colors (LeetCode 75) — Dutch National Flag
     *
     * Sort array of 0s, 1s, 2s in-place without sorting algorithm.
     *
     * Example: nums = [2,0,2,1,1,0] -> [0,0,1,1,2,2]
     *
     * Three pointers:
     *   low  = 0         (everything before low is 0)
     *   mid  = 0         (current element being examined)
     *   high = n-1       (everything after high is 2)
     *
     * Rules:
     *   nums[mid] == 0 -> swap(mid, low), low++, mid++
     *   nums[mid] == 1 -> mid++ (already in place)
     *   nums[mid] == 2 -> swap(mid, high), high-- (DON'T mid++, swapped element unseen)
     *
     * Trace by hand first:
     *   [2,0,2,1,1,0], low=0, mid=0, high=5
     *   mid=0: nums[0]=2 -> swap(0,5)=[0,0,2,1,1,2], high=4
     *   mid=0: nums[0]=0 -> swap(0,0)=[0,0,2,1,1,2], low=1, mid=1
     *   mid=1: nums[1]=0 -> swap(1,1)=[0,0,2,1,1,2], low=2, mid=2
     *   mid=2: nums[2]=2 -> swap(2,4)=[0,0,1,1,2,2], high=3
     *   mid=2: nums[2]=1 -> mid=3
     *   mid=3: nums[3]=1 -> mid=4
     *   mid=4 > high=3 -> done ✓
     */
    fun sortColors(nums: IntArray): Unit {
        TODO("Implement Dutch National Flag with low/mid/high three pointers")
    }
    // Time: O(?)
    // Space: O(?)

    /**
     * Problem 4b: 3Sum (LeetCode 15)
     *
     * Find all unique triplets in array that sum to 0.
     *
     * Example: nums = [-1,0,1,2,-1,-4] -> [[-1,-1,2],[-1,0,1]]
     *
     * Strategy: Sort first, then for each element at index i,
     *   run Pattern 1 (opposite ends) on the subarray i+1..end targeting -nums[i].
     *
     * Key details to get right:
     *   1. Skip duplicate values for i (if nums[i] == nums[i-1], continue)
     *   2. After finding a triplet, skip duplicates for left and right pointers too
     *   3. Early exit: if nums[i] > 0, no triplet can sum to 0 (array is sorted)
     *
     * Trace by hand first:
     *   sorted: [-4,-1,-1,0,1,2]
     *   i=0: nums[0]=-4, target=4, left=1(-1), right=5(2) -> sum=-3<4 -> left++
     *     left=2(-1), right=5(2) -> sum=1<4 -> left++
     *     left=3(0),  right=5(2) -> sum=2<4 -> left++
     *     left=4(1),  right=5(2) -> sum=3<4 -> left++
     *     left>=right -> done with i=0
     *   i=1: nums[1]=-1, target=1, left=2(-1), right=5(2) -> sum=1==1 -> add [-1,-1,2]
     *     skip dups: left=3(0), right=4(1) -> sum=1==1 -> add [-1,0,1]
     *     skip dups: left=4, right=3 -> left>=right -> done
     *   i=2: nums[2]=-1 == nums[1]=-1 -> skip (duplicate i)
     *   i=3: nums[3]=0 > 0? No. target=-0=0, left=4(1), right=5(2) -> sum=3>0 -> right--
     *     left>=right -> done
     *   result: [[-1,-1,2],[-1,0,1]] ✓
     */
    fun threeSum(nums: IntArray): List<List<Int>> {
        TODO("Sort + fix i + Pattern 1 on remaining subarray")
    }
    // Time: O(?)  hint: sorting + outer loop + inner two-pointer
    // Space: O(?) hint: sorting in Kotlin uses O(log n) stack

    /**
     * Problem 4c: 4Sum (LeetCode 18)
     *
     * Find all unique quadruplets that sum to target.
     *
     * Example: nums = [1,0,-1,0,-2,2], target = 0 -> [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
     *
     * Strategy: Extend 3Sum by adding one more outer loop.
     *   Fix i, fix j (i+1..n-2), then two-pointer on j+1..n-1.
     *   Skip duplicates at every level (i, j, left, right).
     *
     * Key early-exit optimizations:
     *   - If nums[i]+nums[i+1]+nums[i+2]+nums[i+3] > target -> break (too large)
     *   - If nums[i]+nums[n-3]+nums[n-2]+nums[n-1] < target -> continue (too small)
     *   - Same pruning for j level
     */
    fun fourSum(nums: IntArray, target: Int): List<List<Int>> {
        TODO("Sort + fix i + fix j + Pattern 1 on remaining subarray")
    }
    // Time: O(?)
    // Space: O(?)
}

fun main() {
    val lab = TwoPointersLab()

    // Pattern 1 tests
    println("=== Pattern 1: Opposite Ends ===")
    println(lab.isPalindrome("A man, a plan, a canal: Panama"))  // true
    println(lab.isPalindrome("race a car"))                       // false
    println(lab.twoSumII(intArrayOf(2, 7, 11, 15), 9).toList())  // [1, 2]
    println(lab.maxWater(intArrayOf(1, 8, 6, 2, 5, 4, 8, 3, 7))) // 49
    println(lab.trapBruteForce(intArrayOf(0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1))) // 6

    // Pattern 2 tests
    println("\n=== Pattern 2: Fast / Slow ===")
    val arr1 = intArrayOf(1, 1, 2)
    println(lab.removeDuplicates(arr1))                           // 2
    val arr2 = intArrayOf(0, 1, 0, 3, 12)
    lab.moveZeroes(arr2); println(arr2.toList())                  // [1, 3, 12, 0, 0]
    println(lab.findDuplicate(intArrayOf(1, 3, 4, 2, 2)))        // 2

    // Pattern 3 tests
    println("\n=== Pattern 3: Two Sequences ===")
    println(lab.isSubsequence("ace", "abcde"))                    // true
    println(lab.isSubsequence("aec", "abcde"))                    // false
    val m1 = intArrayOf(1, 2, 3, 0, 0, 0)
    lab.merge(m1, 3, intArrayOf(2, 5, 6), 3); println(m1.toList()) // [1, 2, 2, 3, 5, 6]
    println(lab.backspaceCompare("ab#c", "ad#c"))                 // true
    println(lab.backspaceCompare("ab##", "c#d#"))                 // true

    // Pattern 4 tests
    println("\n=== Pattern 4: Three Pointers ===")
    val colors = intArrayOf(2, 0, 2, 1, 1, 0)
    lab.sortColors(colors); println(colors.toList())              // [0, 0, 1, 1, 2, 2]
    println(lab.threeSum(intArrayOf(-1, 0, 1, 2, -1, -4)))       // [[-1,-1,2],[-1,0,1]]
    println(lab.fourSum(intArrayOf(1, 0, -1, 0, -2, 2), 0))      // [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
}
