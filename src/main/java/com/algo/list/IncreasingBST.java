package com.algo.list;

/**
 * Given the root of a binary search tree, rearrange the tree in in-order so that the leftmost node in the tree
 * is now the root of the tree, and every node has no left child and only one right child.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: root = [5,3,6,2,4,null,8,1,null,null,null,7,9]
 * Output: [1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]
 * Example 2:
 * <p>
 * <p>
 * Input: root = [5,1,7]
 * Output: [1,null,5,null,7]
 *
 * @author mkarki
 */
public class IncreasingBST {

    // Definition for a binary tree node.
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

    private TreeNode curr;

    public TreeNode increasingBST(TreeNode root) {
        curr = new TreeNode(0);
        TreeNode ans = curr;
        inOrder(root);
        return ans.right;
    }

    private void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        root.left = null;
        curr.right = root;
        curr = root;
        inOrder(root.right);
    }

}
