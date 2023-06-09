package easy

import datastructure.ListNode

private class Solution876 {
    fun middleNode(head: ListNode?): ListNode? {
        var slow = head
        var fast = head

        if(head?.next == null){
            return head
        }

        while(fast?.next != null){
            slow = slow?.next
            fast = fast.next?.next
        }

        return slow
    }
}