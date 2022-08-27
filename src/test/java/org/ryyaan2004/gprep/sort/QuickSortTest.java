package org.ryyaan2004.gprep.sort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class QuickSortTest {

    @Test
    void sorts() {
        int[] toSort = new int[]{10,2,5,9,1,4,3,8,6,7};
        QuickSort cut = new QuickSort();
        int first = 0, mid = 4, end = 9;
        cut.quickSort(toSort, first, end);
        assertEquals(1, toSort[first]);
        assertEquals(5, toSort[mid]);
        assertEquals(10, toSort[end]);
    }

    @Test
    void sort_large_random() {
        Random rand = new Random();
        int[] toSort = rand.ints(1_000_000, 1, 5_000_000).toArray();
        int[] stdLibSorted = Arrays.stream(toSort).sorted().toArray();
        QuickSort cut = new QuickSort();
        cut.quickSort(toSort, 0, toSort.length - 1);
        assertArrayEquals(toSort, stdLibSorted);
    }
}
