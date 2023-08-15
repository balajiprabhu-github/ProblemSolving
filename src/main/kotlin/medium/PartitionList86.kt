package medium

import datastructure.ListNode
import datastructure.insertNode
import datastructure.printLinkedList

fun main() {

    var listNode = ListNode(1)
     listNode = insertNode(listNode,4)
     listNode = insertNode(listNode,3)
     listNode = insertNode(listNode,2)
     listNode = insertNode(listNode,5)
     listNode = insertNode(listNode,2)
    printLinkedList(Solution86().partition(listNode,3))

    var listNode1 = ListNode(1)
    listNode1 = insertNode(listNode1,2)
    printLinkedList( Solution86().partition(listNode1,2))

}

private class Solution86 {
    fun partition(head: ListNode?, x: Int): ListNode? {

        var current = head
        val small  = ListNode(0)
        val higher = ListNode(0)

        var smallHead : ListNode? = small
        var higherHead : ListNode? = higher

        while (current != null) {

            if (current.`val` < x) {
                // small
                smallHead?.next = current
                smallHead = smallHead?.next

            } else {
                // higher

                higherHead?.next = current
                higherHead = higherHead?.next
            }

            current = current.next
        }

        higherHead?.next = null
        smallHead?.next = higher.next

        return small.next
    }
}