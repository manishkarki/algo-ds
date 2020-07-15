package com.algo.list;

/**
 * @author mkarki
 */
public class Node {
    static class ListNode {
        int data;
        ListNode next;

        @Override
        public String toString() {
            return "data:" + data;
        }
    }

    // A utility function to create a new node
    static ListNode newNode(int key) {
        ListNode temp = new ListNode();
        temp.data = key;
        temp.next = null;
        return temp;
    }

    static void printlist(ListNode node) {
        while (node != null) {
            System.out.print(node.data + "->");
            node = node.next;
        }
        System.out.println("NULL");
    }
}
