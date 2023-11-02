package medium

import datastructure.TreeNode

class Solution2265 {

    var count = 0

    fun averageOfSubtree(root: TreeNode?): Int {
        if(root == null) {
            return count
        }

        postOrder(root)

        return count
    }

    fun postOrder(root: TreeNode?) : IntArray {
        if(root == null) {
            return intArrayOf(0,0)
        }

        val left = postOrder(root.left)
        val right = postOrder(root.right)

        val totalSum = left[0] + right[0] + root.`val`
        val totalNode = left[1] + right[1] + 1

        if(totalSum/totalNode == root.`val`) {
            count++
        }

        return intArrayOf(totalSum,totalNode)
    }
}