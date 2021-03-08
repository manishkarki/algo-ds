package com.algo.tree;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;

/**
 * @author mkarki
 */
class IncreasingBSTTest {

    @Test
    void testIncreasingBST() {
        IncreasingBST increasingBST = new IncreasingBST();
        TreeNode three = new TreeNode(3);
        TreeNode two = new TreeNode(2);
        TreeNode one = new TreeNode(1);
        TreeNode four = new TreeNode(4);
        TreeNode six = new TreeNode(6);
        TreeNode eight = new TreeNode(8);
        TreeNode seven = new TreeNode(7);
        TreeNode nine = new TreeNode(9);

        /*
                                          5
                                   3              6
                              2        4                 8
                          1                           7      9
         */

        two.left = one;
        three.left = two;
        three.right = four;
        eight.left = seven;
        eight.right = nine;
        six.right = eight;
        TreeNode root = new TreeNode(5, three, six);
        TreeNode retNode = increasingBST.increasingBST(root);
        assertThat(retNode, is(one));
        assertThat(retNode.left, is(nullValue()));
        assertThat(retNode.right, is(two));
        assertThat(two.left, is(nullValue()));
        assertThat(two.right, is(three));
    }
}