package com.algo.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author mkarki
 */
public class BinaryTreeDFS {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * Given a binary tree, find its minimum depth.
     *
     * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
     *
     * Note: A leaf is a node with no children.
     *
     * Example:
     *
     * Given binary tree [3,9,20,null,null,15,7],
     *
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * return its minimum depth = 2.
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int level = 1;

        while (!q.isEmpty()) {
            int size = q.size();
            while (size > 0) {
                TreeNode polled = q.poll();
                if (polled.left == null && polled.right == null) {
                    return level;
                }
                if (polled.left != null) {
                    q.add(polled.left);
                }
                if (polled.right != null) {
                    q.add(polled.right);
                }
                size--;
            }
            level++;
        }
        return level;
    }
}
