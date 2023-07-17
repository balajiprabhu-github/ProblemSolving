package medium

import datastructure.ListNode
import datastructure.insertNode
import datastructure.printLinkedList
import java.util.Stack

fun main() {
    val listOne = ListNode(7)
    insertNode(listOne,2)
    insertNode(listOne,4)
    insertNode(listOne,3)
    printLinkedList(listOne)

    val listTwo = ListNode(5)
    insertNode(listTwo,6)
    insertNode(listTwo,4)
    printLinkedList(listTwo)

    printLinkedList(Solution445().addTwoNumbers(listOne,listTwo))

}

class Solution445 {
    fun addTwoNumbers(listOne: ListNode?, listTwo: ListNode?): ListNode? {

        val stackOne = Stack<Int>()
        val stackTwo = Stack<Int>()

        var l1 = listOne
        var l2 = listTwo

        var carry = 0

        while (l1 != null || l2 != null) {

            if (l1 != null) {
                stackOne.push(l1.`val`)
                l1 = l1.next
            }

            if (l2 != null) {
                stackTwo.push(l2.`val`)
                l2 = l2.next
            }
        }

        var  result : ListNode? = null
        while (stackOne.isNotEmpty() || stackTwo.isNotEmpty() || carry != 0) {

            var sum = carry

            if (stackOne.isNotEmpty()) {
                sum += stackOne.pop()
            }

            if (stackTwo.isNotEmpty()) {
                sum += stackTwo.pop()
            }

            carry = sum/10

            sum %= 10

            val newNode = ListNode(sum)
            newNode.next = result
            result = newNode

        }


        return result
    }

}