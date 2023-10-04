
class MyHashMap() {
    private data class ListNode(val key: Int, var value: Int, var next: ListNode? = null)

    private val size = 1000 // You can adjust the size based on your requirements.
    private val buckets: Array<ListNode?> = arrayOfNulls(size)

    private fun hash(key: Int): Int {
        return key % size
    }

    /** Inserts a (key, value) pair into the HashMap. */
    fun put(key: Int, value: Int) {
        val index = hash(key)
        val newNode = ListNode(key, value)

        if (buckets[index] == null) {
            buckets[index] = newNode
        } else {
            var current = buckets[index]
            var prev: ListNode? = null

            while (current != null) {
                if (current.key == key) {
                    current.value = value // Update the value if the key already exists.
                    return
                }
                prev = current
                current = current.next
            }

            prev?.next = newNode
        }
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key. */
    fun get(key: Int): Int {
        val index = hash(key)
        var current = buckets[index]

        while (current != null) {
            if (current.key == key) {
                return current.value
            }
            current = current.next
        }

        return -1
    }

    /** Removes the key and its corresponding value if the map contains the mapping for the key. */
    fun remove(key: Int) {
        val index = hash(key)
        var current = buckets[index]
        var prev: ListNode? = null

        while (current != null) {
            if (current.key == key) {
                if (prev == null) {
                    buckets[index] = current.next
                } else {
                    prev.next = current.next
                }
                return
            }
            prev = current
            current = current.next
        }
    }
}
