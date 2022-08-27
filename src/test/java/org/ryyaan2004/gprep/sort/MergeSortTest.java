package org.ryyaan2004.gprep.sort;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

public class MergeSortTest {

    @Test
    void sorts() {
        int[] toSort = new int[]{10,2,5,9,1,4,3,8,6,7};
        MergeSort cut = new MergeSort();
        int first = 0, mid = 4, end = 9;
        cut.sort(toSort, first, end);
        assertEquals(1, toSort[first]);
        assertEquals(5, toSort[mid]);
        assertEquals(10, toSort[end]);
    }

    @Test
    void sort_large_random() {
        Random rand = new Random();
        int[] toSort = rand.ints(1_000_000, 1, 5_000_000).toArray();
        int[] stdLibSorted = Arrays.stream(toSort).sorted().toArray();
        MergeSort cut = new MergeSort();
        cut.sort(toSort, 0, toSort.length - 1);
        assertArrayEquals(toSort, stdLibSorted);
    }
}
