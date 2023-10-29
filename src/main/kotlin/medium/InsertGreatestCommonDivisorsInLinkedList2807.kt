package medium

import datastructure.ListNode

private class Solution2807 {

    fun insertGreatestCommonDivisors(head: ListNode?): ListNode? {

        if(head?.next == null) {
            return head
        }

        var current = head


        while(current?.next != null) {
            val a = current.`val`
            val b = current.next?.`val`
            val newNode = ListNode(gcd(a,b ?: 0))
            newNode.next = current.next
            current.next = newNode
            current = newNode.next
        }

        return head

    }

    private fun gcd(a: Int, b:Int) : Int {
        return if(b == 0) {
            a
        } else {
            gcd(b,a % b)
        }
    }
}