package com.algo.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author mkarki
 */
public class BinaryTree {
    Node root;

    static class Node {
        int data;
        Node left, right;
    }

    public static Node newNode(int data) {
        Node node = new Node();
        node.data = data;
        node.left = node.right = null;
        return node;
    }

    /**
     * find Height of Binary Tree
     * Height of a Binary Tree is a number of edges between the tree's root and its furthest leaf
     */
    public static int getHeight(Node root) {
        //using recursion
        // if the element itself is null, it doesn't count to the height, base condition
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }

    /**
     * find Height of Binary Tree using iteration
     * Height of a Binary Tree is a number of edges between the tree's root and its furthest leaf
     */
    public static int getHeightUsingIteration(Node root) {
        Queue<Node> q = new LinkedList<>();
        //add the root element
        q.add(root);
        //add the delimiter for each level
        q.add(null);
        int height = 1;
        while (q.size() > 0) {
            Node polled = q.poll();
            //if it's at the same level, then just add left and right elements
            if (polled != null) {
                if(polled.left != null) {
                    q.add(polled.left);
                }
                if(polled.right != null) {
                    q.add(polled.right);
                }
                continue;
            }
            //if there's no element left after polling the null element, then we have reached the leaf or the bottom level
            if (q.size() == 0)
                return height;
            q.add(null);
            height++;
        }
        return height;
    }

}
