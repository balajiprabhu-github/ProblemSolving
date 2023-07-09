package easy

import datastructure.ListNode
import datastructure.insertNode
import datastructure.printLinkedList

fun main() {
    val listNode = ListNode(1)
    insertNode(listNode,1)
    insertNode(listNode,2)
    insertNode(listNode,3)
    insertNode(listNode,3)
    printLinkedList(listNode)
    printLinkedList(Solution83().deleteDuplicates(listNode))
}

// 1 1 2 3 3
// 1
private class Solution83 {
    fun deleteDuplicates(head: ListNode?): ListNode? {

        if (head == null) return head

        var pointer = head
        while (pointer != null) {
            if (pointer.`val` == pointer.next?.`val`) {
                val pointerNext = pointer.next?.next
                pointer.next = pointerNext
            } else {
                pointer = pointer.next
            }
        }

        return head
    }
}