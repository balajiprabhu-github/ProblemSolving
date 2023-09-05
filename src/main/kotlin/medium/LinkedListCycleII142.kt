package medium

import datastructure.ListNode

fun main() {
    Solution142().detectCycle(ListNode(0))
}

private class Solution142 {
    fun detectCycle(head: ListNode?): ListNode? {

        var slow = head
        var fast = head

        while (fast?.next != null) {
            slow = slow?.next
            fast = fast.next?.next

            if (slow == fast) {
                return fast?.next
            }
        }

        return null
    }
}