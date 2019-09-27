package com.algo.tree;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
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

    /**
     * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).
     *
     * For example:
     * Given binary tree [3,9,20,null,null,15,7],
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * return its zigzag level order traversal as:
     * [
     *   [3],
     *   [20,9],
     *   [15,7]
     * ]
     *
     * @param root
     * @return
     */
    public List<List<Integer>> zigzagLevelOrderLevelCount(TreeNode root) {
        if(root == null) {
            return new LinkedList<>();
        }
        List<List<Integer>> zigzaggedNodes = new LinkedList<>();
        Queue<TreeNode> treeNodeQueue = new LinkedList<>();
        treeNodeQueue.add(root);
        //this marks the end has been reached
        treeNodeQueue.add(null);
        int level = 0;

        while(!treeNodeQueue.isEmpty()) {
            int size = treeNodeQueue.size();
            List<Integer> interList = new LinkedList<>();
            while(size > 0) {
                TreeNode polled = treeNodeQueue.poll();
                if(polled == null) {
                    break;
                }
                interList.add(polled.val);
                if(polled.left != null) {
                    treeNodeQueue.add(polled.left);
                }
                if(polled.right != null) {
                    treeNodeQueue.add(polled.right);
                }
                size--;
            }
            if(level % 2 != 0) {
                Collections.reverse(interList);
            }
            zigzaggedNodes.add(interList);
            level++;
        }
        return zigzaggedNodes;
    }

    /**
     * the continuation of above problem, but a different approach, instead of taking a counter of each level,
     * we now flip-flop a flag to indicate if this is the level that has reciprocal order,
     * then we take the same into the consideration while adding to the intermediary list
     * @param root
     * @return
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null) {
            return new LinkedList<>();
        }
        List<List<Integer>> zigzaggedNodes = new LinkedList<>();
        Queue<TreeNode> treeNodeQueue = new LinkedList<>();
        treeNodeQueue.add(root);
        boolean zigzag = false;

        while(!treeNodeQueue.isEmpty()) {
            int size = treeNodeQueue.size();
            List<Integer> interList = new LinkedList<>();
            while(size > 0) {
                TreeNode polled = treeNodeQueue.poll();
                if(zigzag) {
                    interList.add(0, polled.val);
                } else {
                    interList.add(polled.val);
                }

                if(polled.left != null) {
                    treeNodeQueue.add(polled.left);
                }
                if(polled.right != null) {
                    treeNodeQueue.add(polled.right);
                }
                size--;
            }
            zigzaggedNodes.add(interList);
            zigzag = !zigzag;
        }
        return zigzaggedNodes;
    }
}
