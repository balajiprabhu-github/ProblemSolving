package datastructure


fun main() {

    var listNode = insertNode(null,3)
    listNode = insertNode(listNode,4)
    listNode = insertNode(listNode,5)
    listNode = insertNode(listNode,6)
    listNode = insertNode(listNode,7)
    listNode = insertNode(listNode,8)

    printLinkedList(listNode)
    printLinkedList(reverseList(listNode))

}

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

fun reverseList(head: ListNode?) : ListNode? {

    if (head?.next == null) {
        return head
    }

    var prev : ListNode? = null
    var current = head
    var next : ListNode?

    while (current != null) {
        next = current.next
        current.next = prev
        prev = current
        current = next
    }

    return prev
}