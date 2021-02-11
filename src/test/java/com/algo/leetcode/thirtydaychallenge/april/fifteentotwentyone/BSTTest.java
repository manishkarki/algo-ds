package com.algo.leetcode.thirtydaychallenge.april.fifteentotwentyone;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author mkarki
 */
class BSTTest {
    private BST bst;

    @BeforeEach
    void setup() {
        bst = new BST();
    }

    @Test
    void testBSTFromPreOrderI() {
        int pre[] = new int[]{10, 5, 1, 7, 40, 50};
        BST.TreeNode root = bst.bstFromPreOrder(pre);
        bst.printInorder(root);
    }

    @Test
    void testBSTFromPreOrderII() {
        int pre[] = new int[]{8, 5, 1, 7, 10, 12};
        BST.TreeNode root = bst.bstFromPreOrder(pre);
        bst.printInorder(root);
    }

    @Test
    void testSomething() {
        String words = "word1, word2 word3, word4";
        String[] splittedWords = words.split(",");
        Arrays.stream(splittedWords)
                .forEach(System.out::println);
    }
}