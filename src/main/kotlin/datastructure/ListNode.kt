package datastructure

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

fun insertNode(head: ListNode?, `val`: Int): ListNode {
    val newNode = ListNode(`val`)
    if (head == null) {
        return newNode
    }
    var current = head
    while (current?.next != null) {
        current = current.next
    }
    current?.next = newNode
    return head
}

fun deleteNode(head: ListNode?, `val`: Int): ListNode? {
    if (head == null) {
        return null
    }
    if (head.`val` == `val`) {
        return head.next
    }
    var current = head
    var prev: ListNode? = null
    while (current != null && current.`val` != `val`) {
        prev = current
        current = current.next
    }
    prev?.next = current?.next
    return head
}

fun printLinkedList(head: ListNode?) {
    var current = head
    while (current != null) {
        print("${current.`val`} ")
        current = current.next
    }
    println()
}