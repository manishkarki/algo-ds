package com.algo.tree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.algo.tree.BinaryTree.newNode;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author mkarki
 */
class BinaryTreeTest {
    private BinaryTree binaryTree;

    @BeforeEach
    public void initialize() {
        binaryTree = new BinaryTree();
    }

    @Test
    void testGetHeightUsingRecursion() {
        binaryTree.root = newNode(1);
        binaryTree.root.left = newNode(2);
        binaryTree.root.right = newNode(3);
        binaryTree.root.left.left = newNode(4);
        binaryTree.root.left.right = newNode(5);

        assertEquals(3, binaryTree.getHeight(binaryTree.root));
    }

    @Test
    void testGetHeightUsingIteration() {
        binaryTree.root = newNode(1);
        binaryTree.root.left = newNode(2);
        binaryTree.root.right = newNode(3);
        binaryTree.root.left.left = newNode(4);
        binaryTree.root.left.right = newNode(5);

        assertEquals(3, binaryTree.getHeightUsingIteration(binaryTree.root));
    }
}