package easy

import datastructure.ListNode
import datastructure.insertNode

fun main() {

    val listNode = ListNode(1)
    insertNode(listNode,0)
    insertNode(listNode,1)

    println(Solution1290().getDecimalValue(listNode))
}

private class Solution1290 {
    fun getDecimalValue(head: ListNode?): Int {

        var count  = 0
        var result = 0
        var temp = head

        while (temp != null) {
            ++count
            temp = temp.next
        }

        temp = head

        while (temp != null) {
            val pow = --count
            val digit = Math.pow(2.00,pow.toDouble())
            result += temp.`val` * digit.toInt()
            temp = temp.next
        }


        return result
    }
}