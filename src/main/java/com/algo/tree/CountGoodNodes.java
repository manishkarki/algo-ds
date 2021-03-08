package com.algo.tree;

/**
 * Given a binary tree root, a node X in the tree is named good if in the path from root to X there are no nodes with a value greater than X.
 * <p>
 * Return the number of good nodes in the binary tree.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * <p>
 * Input: root = [3,1,4,3,null,1,5]
 * Output: 4
 * Explanation: Nodes in blue are good.
 * Root Node (3) is always a good node.
 * Node 4 -> (3,4) is the maximum value in the path starting from the root.
 * Node 5 -> (3,4,5) is the maximum value in the path
 * Node 3 -> (3,1,3) is the maximum value in the path.
 * Example 2:
 * <p>
 * <p>
 * <p>
 * Input: root = [3,3,null,4,2]
 * Output: 3
 * Explanation: Node 2 -> (3, 3, 2) is not good, because "3" is higher than it.
 * Example 3:
 * <p>
 * Input: root = [1]
 * Output: 1
 * Explanation: Root is considered as good.
 *
 * @author mkarki
 */
public class CountGoodNodes {
    int goodNodes = 0;

    public int goodNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        countGoodNodes(root, root.val);
        return goodNodes;
    }

    private void countGoodNodes(TreeNode node, int currMax) {
        if (node == null) {
            return;
        }

        if (node.val != null && currMax <= node.val) {
            currMax = node.val;
            goodNodes++;
        }
        countGoodNodes(node.left, currMax);
        countGoodNodes(node.right, currMax);
    }
}
