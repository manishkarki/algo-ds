package com.algo.list;

/**
 * @author mkarki
 */
public class ListPivot {

    /**
     * Given a singly linkedList, and an integer k, perform pivoting with respect to k
     * i.e the number less than pivot should appear in the left, and greater in the right
     */
    public static Node listPivoting(Node head, int k) {
        Node lessHead = newNode(0);
        Node greaterHead = newNode(0);
        Node equalHead = newNode(0);
        Node lessIter = lessHead;
        Node greaterIter = greaterHead;
        Node equalIter = equalHead;

        Node iter = head;

        while(iter != null) {
            if(iter.data < k) {
                lessIter.next = iter;
                lessIter = iter;
            } else if(iter.data == k) {
                equalIter.next = iter;
                equalIter = iter;
            } else if( iter.data > k) {
                greaterIter.next = iter;
                greaterIter = iter;
            }
            iter = iter.next;
        }
        greaterIter.next = null;
        equalIter.next = greaterHead.next;
        lessIter.next = equalHead.next;

        return lessHead.next;
    }

    /**
     * We are given a linked list and positions m and n. We need to reverse the linked list from position m to n.
     *
     * Examples:
     *
     * Input : 10->20->30->40->50->60->70->NULL
     *         m = 3, n = 6
     * Output : 10->20->60->50->40->30->70->NULL
     *
     * Input :  1->2->3->4->5->6->NULL
     *          m = 2, n = 4
     * Output : 1->4->3->2->5->6->NULL
     * @param head
     * @param m
     * @param n
     * @return
     */
    public static Node reverseInBetween(Node head, int m, int n) {
        if(head == null) {
            return null;
        }
        Node dummy = newNode(0);
        dummy.next = head;
        Node prev = dummy;

        int k = 1;
        while(k++ < m) {
            prev = prev.next;
        }

        Node iter = prev.next;

        while(m++ < n) {
            Node temp = iter.next;
            iter.next = temp.next;
            temp.next = prev.next;
            prev.next = temp;
        }
        return dummy.next;
    }


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

    public static void main(String[] args) {
        Node n = newNode(3);
        n.next = newNode(2);
        n.next.next = newNode(2);
        n.next.next.next = newNode(11);
        n.next.next.next.next = newNode(7);
        n.next.next.next.next.next = newNode(5);
        n.next.next.next.next.next.next = newNode(11);

        printlist(reverseInBetween(n, 3, 6));
    }
}
