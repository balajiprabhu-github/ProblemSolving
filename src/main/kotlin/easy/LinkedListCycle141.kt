package easy

import datastructure.ListNode

fun main() {
    Solution141().hasCycle(ListNode(1))
}

private class Solution141 {
    fun hasCycle(head: ListNode?): Boolean {

        var slow = head
        var fast = head

        while (fast?.next != null) {
            slow = slow?.next
            fast = fast.next?.next

            if (slow == fast) {
                return true
            }
        }

        return false
    }
}