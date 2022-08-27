package org.ryyaan2004.gprep.search;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class SimpleBinaryTest {

    @Test
    void finds_number_when_present() {
        int[] nums = new int[]{0,1,2,3,40, 50, 55,57,58,59, 100};
        int expected = 3;
        SimpleBinary cut = new SimpleBinary();
        int actual = cut.binarySearch(nums, expected);
        assertEquals(expected, actual);
    }

    @Test
    void negative_one_when_not_present() {
        int[] nums = new int[]{0,1,2,3,4};
        int badTarget = 42;
        int expected = -1;
        SimpleBinary cut = new SimpleBinary();
        int actual = cut.binarySearch(nums, badTarget);
        assertEquals(expected, actual);
    }
}
