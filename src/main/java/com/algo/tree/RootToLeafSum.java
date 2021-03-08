package com.algo.tree;

/**
 * You are given the root of a binary tree where each node has a value 0 or 1.
 * <p>
 * Each root-to-leaf path represents a binary number starting with the most significant bit.
 * For example, if the path is 0 -> 1 -> 1 -> 0 -> 1, then this could represent 01101 in binary, which is 13.
 * <p>
 * For all leaves in the tree, consider the numbers represented by the path from the root to that leaf.
 * <p>
 * Return the sum of these numbers. The answer is guaranteed to fit in a 32-bits integer.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: root = [1,0,1,0,1,0,1]
 * Output: 22
 * Explanation: (100) + (101) + (110) + (111) = 4 + 5 + 6 + 7 = 22
 * Example 2:
 * <p>
 * Input: root = [0]
 * Output: 0
 * Example 3:
 * <p>
 * Input: root = [1]
 * Output: 1
 * Example 4:
 * <p>
 * Input: root = [1,1]
 * Output: 3
 *
 * @author mkarki
 */
public class RootToLeafSum {

    public int sumRootToLeaf(BinaryTreeDFS.TreeNode root) {
        BinaryTreeDFS.TreeNode curr = root;
        return calculateSum(curr, 0);
    }

    private int calculateSum(BinaryTreeDFS.TreeNode curr, int sum) {
        if (curr == null) {
            return 0;
        }
        sum = sum * 2 + sum;
        if (curr.left == null && curr.right == null) {
            return sum;
        }

        return calculateSum(curr.left, sum) + calculateSum(curr.right, sum);
    }

}
