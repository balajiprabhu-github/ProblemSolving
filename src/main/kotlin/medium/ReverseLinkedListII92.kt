package medium
import datastructure.ListNode

fun main() {

}

private class Solution92 {
    fun reverseBetween(head: ListNode?, left: Int, right: Int): ListNode? {

        val dummy : ListNode? = ListNode(0)
        dummy?.next = head
        var leftPre = dummy
        var current = head

        for (i in 0 until left-1){
            current = current?.next
            leftPre = leftPre?.next
        }

        var tempCurrent = current
        var prev : ListNode? = null

        for (i in 0..(right-left)) {
            val next = current?.next
            current?.next = prev
            prev = current
            current = next
        }

        leftPre?.next = prev
        tempCurrent?.next = current

        return dummy?.next
    }


}