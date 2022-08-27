package org.ryyaan2004.gprep.sort;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class LinkedListTest {

    @Test
    void test_sort() {
        LinkedList cut = new LinkedList();
        Random rand = new Random();
        for (int i = 0; i < 10; i++) {
            int val = rand.nextInt();
            cut.push(val);
        }
        cut.mergeSort(cut.head);
        LinkedList.Node head = cut.head;
        while (head.next != null) {
            assertTrue(head.val <= head.next.val);
            head = head.next;
        }
    }
}
