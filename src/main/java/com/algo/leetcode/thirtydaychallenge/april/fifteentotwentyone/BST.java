package com.algo.leetcode.thirtydaychallenge.april.fifteentotwentyone;

import java.util.Stack;

/**
 * @author mkarki
 */
public class BST {
    /**
     * Return the root node of a binary search tree that matches the given preorder traversal.
     * <p>
     * (Recall that a binary search tree is a binary tree where for every node, any descendant of node.left has a value < node.val, and any descendant of node.right has a value > node.val.  Also recall that a preorder traversal displays the value of the node first, then traverses node.left, then traverses node.right.)
     * <p>
     * It's guaranteed that for the given test cases there is always possible to find a binary search tree with the given requirements.
     * <p>
     * Example 1:
     * <p>
     * Input: [8,5,1,7,10,12]
     * Output: [8,5,10,1,7,null,12]
     * <p>
     * <p>
     * <p>
     * Constraints:
     * <p>
     * 1 <= preorder.length <= 100
     * 1 <= preorder[i] <= 10^8
     * The values of preorder are distinct.
     */
    public TreeNode bstFromPreOrder(int[] preOrder) {
        int len = preOrder.length;

        TreeNode root = new TreeNode(preOrder[0]);
        Stack<TreeNode> treeNodeStack = new Stack<>();
        treeNodeStack.push(root);

        for (int i = 1; i < len; i++) {
            TreeNode temp = null;

            while (!treeNodeStack.isEmpty() && preOrder[i] > treeNodeStack.peek().val) {
                temp = treeNodeStack.pop();
            }
            //make the greater value the right child
            if (temp != null) {
                temp.right = new TreeNode(preOrder[i]);
                treeNodeStack.push(temp.right);
            } else {
                temp = treeNodeStack.peek();
                temp.left = new TreeNode(preOrder[i]);
                treeNodeStack.push(temp.left);
            }

        }

        return root;
    }

    void printInorder(TreeNode node) {
        if (node == null) {
            return;
        }
        printInorder(node.left);
        System.out.print(node.val + " ");
        printInorder(node.right);
    }


    /**
     * Definition for a binary tree node.
     */
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
