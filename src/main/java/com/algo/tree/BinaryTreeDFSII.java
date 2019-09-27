package com.algo.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author mkarki
 */
public class BinaryTreeDFSII extends BinaryTreeDFS {
    /**
     * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
     *
     * For example:
     * Given binary tree [3,9,20,null,null,15,7],
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * return its level order traversal as:
     * [
     *   [3],
     *   [9,20],
     *   [15,7]
     * ]
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) {
            return new LinkedList<>();
        }

        Queue<TreeNode> nodeQueue = new LinkedList<>();
        List<List<Integer>> retList = new LinkedList<>();
        nodeQueue.add(root);

        while(!nodeQueue.isEmpty()) {
            int size = nodeQueue.size();
            List<Integer> interList = new LinkedList<>();
            while(size > 0) {
                TreeNode polled = nodeQueue.poll();
                interList.add(polled.val);
                if(polled.left != null) {
                    nodeQueue.add(polled.left);
                }
                if(polled.right != null) {
                    nodeQueue.add(polled.right);
                }
                size--;
            }
            retList.add(interList);
        }
        return retList;
    }
}
