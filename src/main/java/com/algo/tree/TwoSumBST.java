package com.algo.tree;

import java.util.HashSet;
import java.util.Set;

/**
 * Given the roots of two binary search trees, root1 and root2, return true if and only if there is a node in
 * the first tree and a node in the second tree whose values sum up to a given integer target.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: root1 = [2,1,4], root2 = [1,0,3], target = 5
 * Output: true
 * Explanation: 2 and 3 sum up to 5.
 * Example 2:
 * <p>
 * <p>
 * Input: root1 = [0,-10,10], root2 = [5,1,7,0,2], target = 18
 * Output: false
 *
 * @author mkarki
 */
public class TwoSumBST {
    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        TreeNode curr1 = root1;
        TreeNode curr2 = root2;
        // in order add values from curr1 to set
        Set<Integer> curr1Values = new HashSet<>();
        Set<Integer> curr2Values = new HashSet<>();
        fillInOrder(curr1, curr1Values);
        fillInOrder(curr2, curr2Values);

        for (int currValue : curr1Values) {
            if (curr2Values.contains(target - currValue)) {
                return true;
            }
        }

        return false;
    }

    private void fillInOrder(TreeNode node, Set<Integer> values) {
        if (node == null) {
            return;
        }
        fillInOrder(node.left, values);
        values.add(node.val);
        fillInOrder(node.right, values);
    }
}
