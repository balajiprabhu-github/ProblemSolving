package medium

import datastructure.ListNode

private class Solution2181 {

    fun mergeNodes(head: ListNode?): ListNode? {

        val dummy = ListNode(0)
        var current = dummy
        var node = head
        var currentSum = 0

        while (node != null) {

            if (node.`val` == 0) {
                if (currentSum != 0) {
                    current.next = ListNode(currentSum)
                    current = current.next!!
                    currentSum = 0
                }
            } else {
                currentSum += node.`val`
            }

            node = node.next

        }

        return dummy.next

    }

}