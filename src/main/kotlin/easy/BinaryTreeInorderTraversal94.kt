package easy

import datastructure.TreeNode

class Solution94 {
    fun inorderTraversal(root: TreeNode?): List<Int> {

        val result = mutableListOf<Int>()

        inorderTraversalRecursive(root,result)

        return result

    }

    fun inorderTraversalRecursive(root: TreeNode?, list: MutableList<Int>) {
        if(root == null) {
            return
        }

        inorderTraversalRecursive(root?.left,list)

        list.add(root.`val`)

        inorderTraversalRecursive(root?.right,list)
    }
}