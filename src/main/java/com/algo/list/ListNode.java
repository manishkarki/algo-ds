package com.algo.list;

/**
 * @author mkarki
 */
public class ListNode {
    static class Node {
        int data;
        Node next;

        @Override
        public String toString() {
            return "data:"+data;
        }
    }

    // A utility function to create a new node
    static Node newNode(int key) {
        Node temp = new Node();
        temp.data = key;
        temp.next = null;
        return temp;
    }

    static void printlist(Node node) {
        while (node != null) {
            System.out.print(node.data + "->");
            node = node.next;
        }
        System.out.println("NULL");
    }
}
