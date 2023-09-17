package easy

import datastructure.ListNode

fun main() {

}

private class Solution21 {
    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        if (list1 == null) {
            return list2
        }
        if (list2 == null) {
            return list1
        }
        var tempOne = list1
        var tempTwo = list2
        var result : ListNode? = null
        var tail: ListNode? = null

        while (tempOne != null && tempTwo != null) {
            if (tempOne.`val` < tempTwo.`val`) {
                if (result == null) {
                    result = tempOne
                    tail = result
                } else {
                    tail?.next = tempOne
                    tail = tail?.next
                }
                tempOne = tempOne.next
            } else {
                if (result == null) {
                    result = tempTwo
                    tail = result
                } else {
                    tail?.next = tempTwo
                    tail = tail?.next
                }
                tempTwo = tempTwo.next
            }
        }

        if (tempOne != null) {
            tail?.next = tempOne
        }
        if (tempTwo != null) {
            tail?.next = tempTwo
        }

        return result

        // recursive Solution

//        // Base cases: if either list1 or list2 is null, return the other list
//        if (list1 == null) {
//            return list2
//        }
//        if (list2 == null) {
//            return list1
//        }
//
//        // Compare the values of the current nodes of list1 and list2
//        // Choose the smaller value as the current node of the merged list
//        if (list1.`val` < list2.`val`) {
//            list1.next = mergeTwoLists(list1.next, list2)
//            return list1
//        } else {
//            list2.next = mergeTwoLists(list1, list2.next)
//            return list2
//        }
    }
}