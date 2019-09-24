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
        //if the element itself is null, it doesn't count to the height, base condition
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
        // Base Case
        if (root == null)
            return 0;

        // Create an empty queue for level order traversal
        Queue<Node> q = new LinkedList();

        // Enqueue Root and initialize height
        q.add(root);
        int height = 0;

        while (true) {
            // nodeCount (queue size) indicates number of nodes
            // at current level.
            int nodeCount = q.size();
            if (nodeCount == 0)
                return height;
            height++;

            // Dequeue all nodes of current level and Enqueue all
            // nodes of next level
            while (nodeCount > 0) {
                Node t = q.peek();
                q.remove();
                if (t.left != null)
                    q.add(t.left);
                if (t.right != null)
                    q.add(t.right);
                nodeCount--;
            }
        }
    }

    /**
     * Given a Binary Tree, find the density of it by doing one traversal of it.
     * <p>
     * The density of binary tree is defined as:
     * Density of Binary Tree = Size / Height
     */
    public float density(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        //add a null delimiter
        q.add(null);
        int height = 1, size = 0;
        while (q.size() > 0) {
            Node t = q.poll();

            if (t != null) {
                size++;
                // add left and right elements, if present
                if(t.left != null) {
                    q.add(t.left);
                }
                if(t.right != null) {
                    q.add(t.right);
                }
            } else {
                //if there's no element remaining, then we've got final height and size
                if (q.size() == 0) {
                    break;
                }
                //else we'll add delimiter to the next level and increment the height
                q.add(null);
                height++;
                continue;
            }

        }
        return ((float) size) / height;
    }

}
