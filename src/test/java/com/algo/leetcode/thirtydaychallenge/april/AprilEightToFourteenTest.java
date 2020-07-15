package com.algo.leetcode.thirtydaychallenge.april;

import com.algo.util.ListNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.algo.util.ListNode.printList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * @author mkarki
 */
class AprilEightToFourteenTest {

    private AprilEightToFourteen eightToFourteen;

    @BeforeEach
    void setup() {
        eightToFourteen = new AprilEightToFourteen();
    }

    @Test
    public void testGetMiddleNode() {
        ListNode input = constructLinkedList(1, 6);
        assertThat(eightToFourteen.middleNode(input), is(constructLinkedList(4, 6)));
    }

    public void testGetMiddleNodeWithSingleInput() {
        ListNode input = constructLinkedList(1, 1);
        assertThat(eightToFourteen.middleNode(input), is(constructLinkedList(1, 1)));
    }

    @Test
    public void testGetMiddleNodeV2() {
        ListNode input = constructLinkedList(1, 6);
        assertThat(eightToFourteen.middleNodeV2(input), is(constructLinkedList(4, 6)));
    }

    @Test
    public void testGetMiddleNodeV2WithSingleInput() {
        ListNode input = constructLinkedList(1, 1);
        assertThat(eightToFourteen.middleNodeV2(input), is(constructLinkedList(1, 1)));
    }

    private ListNode constructLinkedList(int start, int end) {
        ListNode head = new ListNode(start);
        ListNode curr = head;
        for (int i = start + 1; i <= end; i++) {
            ListNode next = new ListNode(i);
            next.next = null;
            curr.next = next;
            curr = curr.next;
        }
        printList(head);
        return head;
    }

}