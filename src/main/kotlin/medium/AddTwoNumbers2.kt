package medium

import datastructure.ListNode

class Solution2 {
    fun addTwoNumbers(listOne: ListNode?, listTwo: ListNode?): ListNode? {


        val result = ListNode(0)
        var ptr = result
        var l1 = listOne
        var l2 = listTwo

        var carry = 0

        while(l1 != null || l2 != null){

            var sum = carry

            if(l1 != null) {
                sum += l1.`val`
                l1 = l1.next
            }

            if(l2 != null) {
                sum += l2.`val`
                l2 = l2.next
            }

            carry = sum / 10

            ptr.next = ListNode(sum % 10)
            ptr = ptr.next!!
        }

        if(carry == 1) {
            ptr.next = ListNode(1)
            ptr = ptr.next!!
        }

        return result.next
    }
}