package org.ryyaan2004.gprep.sort;

public class LinkedList {

    Node head = null;

    public static class Node {
        Node next;
        int val;

        public Node(int val) {
            this.val = val;
        }
    }

    Node mergeSort(Node head){
        if (head == null || head.next == null) {
            return head;
        }

        Node middle = getMiddle(head);
        Node nextOfMiddle = middle.next;

        middle.next = null;
        Node left = mergeSort(head);
        Node right = mergeSort(nextOfMiddle);
        return sortedMerge(left, right);
    }

    Node getMiddle(Node head) {
        if (head == null) {
            return head;
        }
        Node slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    void push(int val) {
        Node newNode = new Node(val);
        newNode.next = head;
        head = newNode;
    }

    Node sortedMerge(Node a, Node b) {
        Node result = null;
        if (a == null) {
            return b;
        }
        if (b == null) {
            return a;
        }
        if (a.val <= b.val) {
            result = a;
            result.next = sortedMerge(a.next, b);
        } else {
            result = b;
            result.next = sortedMerge(a, b.next);
        }
        return result;
    }
}
