package com.algo.list;

/**
 * @author mkarki
 */
public class TwoNodeSum {

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

    public Node sum(Node n1, Node n2) {
        if(n1 == null && n2 != null) {
            return n2;
        }
        if(n1 != null && n2 == null) {
            return n1;
        }
        int carry = 0;
        Node dummy = newNode(0);
        Node iter = dummy;
        while(n1 != null || n2 != null || carry != 0) {
            int val = carry + (n1 != null ? n1.data : 0) + (n2 != null ? n2.data : 0);
            System.out.println(val);
            n1 = n1 != null ? n1.next : null;
            n2 = n2 != null ? n2.next : null;
            iter.next = newNode(val % 10);
            carry = val / 10;
            iter = iter.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        TwoNodeSum twoNodeSum = new TwoNodeSum();
        Node n1 = newNode(1);
        n1.next = newNode(2);
        n1.next.next = newNode(7);
        Node n2 = newNode(2);
        n2.next = newNode(3);
        n2.next.next = newNode(7);
        Node result = twoNodeSum.sum(n1, n2);
        printlist(result);
    }
}
