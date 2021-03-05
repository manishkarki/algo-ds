package com.algo.list;

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
        IncreasingBST.TreeNode three = increasingBST.new TreeNode(3);
        IncreasingBST.TreeNode two = increasingBST.new TreeNode(2);
        IncreasingBST.TreeNode one = increasingBST.new TreeNode(1);
        IncreasingBST.TreeNode four = increasingBST.new TreeNode(4);
        IncreasingBST.TreeNode six = increasingBST.new TreeNode(6);
        IncreasingBST.TreeNode eight = increasingBST.new TreeNode(8);
        IncreasingBST.TreeNode seven = increasingBST.new TreeNode(7);
        IncreasingBST.TreeNode nine = increasingBST.new TreeNode(9);

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
        IncreasingBST.TreeNode root = increasingBST.new TreeNode(5, three, six);
        IncreasingBST.TreeNode retNode = increasingBST.increasingBST(root);
        assertThat(retNode, is(one));
        assertThat(retNode.left, is(nullValue()));
        assertThat(retNode.right, is(two));
        assertThat(two.left, is(nullValue()));
        assertThat(two.right, is(three));
    }
}