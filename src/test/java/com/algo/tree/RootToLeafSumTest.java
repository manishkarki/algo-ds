package com.algo.tree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * @author mkarki
 */
class RootToLeafSumTest {
    private RootToLeafSum rootToLeafSum;

    @BeforeEach
    void setup() {
        rootToLeafSum = new RootToLeafSum();
    }

    @Test
    void testSumRootToLeaf() {
        // root = [1,0,1,0,1,0,1]
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(0);
        TreeNode right = new TreeNode(1);
        TreeNode left1 = new TreeNode(0);
        TreeNode right1 = new TreeNode(1);
        TreeNode left2 = new TreeNode(0);
        TreeNode right2 = new TreeNode(1);
        left.left = left1;
        left.right = right1;
        right.left = left2;
        right.right = right2;
        root.left = left;
        root.right = right;
        assertThat(rootToLeafSum.sumRootToLeaf(root), is(22));
    }
}