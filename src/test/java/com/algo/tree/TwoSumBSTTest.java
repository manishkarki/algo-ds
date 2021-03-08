package com.algo.tree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * @author mkarki
 */
class TwoSumBSTTest {

    private TwoSumBST twoSumBST;

    @BeforeEach
    void setup() {
        twoSumBST = new TwoSumBST();
    }

    @Test
    void testTwoSumBSTs() {
        TreeNode left = new TreeNode(1);
        TreeNode right = new TreeNode(4);
        TreeNode root = new TreeNode(2, left, right);

        TreeNode left1 = new TreeNode(0);
        TreeNode right1 = new TreeNode(3);
        TreeNode root1 = new TreeNode(1, left1, right1);

        assertThat(twoSumBST.twoSumBSTs(root, root1, 5), is(true));
        left = new TreeNode(-10);
        right = new TreeNode(10);
        TreeNode left2 = new TreeNode(0);
        TreeNode right2 = new TreeNode(2);
        left1 = new TreeNode(1, left2, right2);
        right1 = new TreeNode(7);
        root = new TreeNode(0, left, right);
        root1 = new TreeNode(5, left1, right1);
        assertThat(twoSumBST.twoSumBSTs(root, root1, 18), is(false));
    }
}