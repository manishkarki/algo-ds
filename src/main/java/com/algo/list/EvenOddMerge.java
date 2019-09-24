package com.algo.list;

import java.util.Arrays;
import java.util.List;

/**
 * @author mkarki
 */
public class EvenOddMerge {

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

    // Rearranges given linked list
// such that all even positioned
// nodes are before odd positioned.
// Returns new head of linked List.
    static Node rearrangeEvenOdd(Node head) {
        // Corner case
        if (head == null)
            return null;

        Node evenDummy = newNode(0);
        Node oddDummy = newNode(0);
        List<Node> nodes = Arrays.asList(evenDummy, oddDummy);
        int turn = 0;
        Node iter = head;
        while (iter != null) {
            System.out.println(nodes.get(turn));
            nodes.get(turn).next = iter;
            nodes.set(turn, nodes.get(turn).next);
            turn ^= 1;
            iter = iter.next;
            System.out.println("oddDummy");
            printlist(oddDummy);
            printlist(evenDummy);
        }
        nodes.get(1).next = null;
        nodes.get(0).next = oddDummy.next;
        return evenDummy.next;
    }

    // A utility function to print a linked list
    static void printlist(Node node) {
        while (node != null) {
            System.out.print(node.data + "->");
            node = node.next;
        }
        System.out.println("NULL");
    }

    // Driver code
    public static void main(String[] args) {
        Node head = newNode(1);
        head.next = newNode(2);
        head.next.next = newNode(3);
        head.next.next.next = newNode(4);
        head.next.next.next.next = newNode(5);

        System.out.println("Given Linked List");
        printlist(head);

        head = rearrangeEvenOdd(head);

        System.out.println("Modified Linked List");
        printlist(head);
    }
}
