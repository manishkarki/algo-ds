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
    }
}