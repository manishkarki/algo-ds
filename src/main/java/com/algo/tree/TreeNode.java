package com.algo.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author mkarki
 */
public class TreeNode {
    Integer val;
    TreeNode left;
    TreeNode right;

    public TreeNode() {
    }

    TreeNode(Integer x) {
        this.val = x;
    }

    TreeNode(Integer val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public TreeNode buildTreePreOrderFromList(List<Integer> nums) {

        TreeNode root = new TreeNode(0);
        root = insertLevelOrder(nums, root, 0);
        printLevelOrder(root);
        return root;
    }

    void printLevelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode tempNode = queue.poll();
            System.out.print(tempNode.val + " ");

            /*Enqueue left child */
            if (tempNode.left != null) {
                queue.add(tempNode.left);
            }

            /*Enqueue right child */
            if (tempNode.right != null) {
                queue.add(tempNode.right);
            }
        }
    }


    public TreeNode insertLevelOrder(List<Integer> nums, TreeNode root, int i) {

        // Base case for recursion
        if (i < nums.size()) {
            if (nums == null || nums.get(i) == null) {
                System.out.println("nums was null for i :" + i);
            }
            TreeNode temp = new TreeNode(nums.get(i));
            root = temp;

            // insert left child
            root.left = insertLevelOrder(nums, root.left, 2 * i + 1);

            // insert right child
            root.right = insertLevelOrder(nums, root.right, 2 * i + 2);
        }
        return root;
    }

}
