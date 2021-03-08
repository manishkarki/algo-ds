package com.algo.tree;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * @author mkarki
 */
class CountGoodNodesTest {
    private CountGoodNodes countGoodNodes;

    @Test
    void goodNodes() {
        countGoodNodes = new CountGoodNodes();
        TreeNode treeNode = new TreeNode();
        treeNode = treeNode.buildTreePreOrderFromList(Arrays.asList(3, 1, 4, 3, null, 1, 5));
        assertThat(countGoodNodes.goodNodes(treeNode), is(4));
    }
}