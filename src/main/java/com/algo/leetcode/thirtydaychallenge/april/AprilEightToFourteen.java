package com.algo.leetcode.thirtydaychallenge.april;

import com.algo.util.ListNode;

/**
 * this has solution for problem listed here
 * https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/529/week-2/
 *
 * @author mkarki
 */
public class AprilEightToFourteen {

    /**
     * Given a non-empty, singly linked list with head node head, return a middle node of linked list.
     * <p>
     * If there are two middle nodes, return the second middle node.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: [1,2,3,4,5]
     * Output: Node 3 from this list (Serialization: [3,4,5])
     * The returned node has value 3.  (The judge's serialization of this node is [3,4,5]).
     * Note that we returned a ListNode object ans, such that:
     * ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, and ans.next.next.next = NULL.
     * Example 2:
     * <p>
     * Input: [1,2,3,4,5,6]
     * Output: Node 4 from this list (Serialization: [4,5,6])
     * Since the list has two middle nodes with values 3 and 4, we return the second one.
     * <p>
     * <p>
     * Note:
     * <p>
     * The number of nodes in the given list will be between 1 and 100.
     */
    public ListNode middleNode(ListNode head) {
        ListNode[] A = new ListNode[100];
        int count = 0;
        while (head.next != null) {
            A[count++] = head;
            head = head.next;
        }
        return A[(count + 1) / 2];
    }

    public ListNode middleNodeV2(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}
