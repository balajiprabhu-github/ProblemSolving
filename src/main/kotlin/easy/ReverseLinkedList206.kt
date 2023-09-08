package easy

import datastructure.ListNode

private class Solution206 {
    fun reverseList(head: ListNode?): ListNode? {
        var prev : ListNode? = null
        var current = head
        var next : ListNode?

        while(current != null) {
            next = current.next
            current.next = prev
            prev = current
            current = next
        }

        return prev
    }
}