package org.ryyaan2004.gprep.search;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BadVersionTest {

    TestVersion cut;

    class TestVersion extends BadVersion {
        int firstBadVersion;
        void set(int n) {
            this.firstBadVersion = n;
        }

        @Override
        boolean isBadVersion(int n) {
            return n >= firstBadVersion;
        }
    }

    @BeforeEach
    void setup() {
        cut = new TestVersion();
    }


    @Test
    void simple_test() {
        cut.set(4);
        int result = cut.firstBadVersion(5);
        assertEquals(4, result);
    }

    @Test
    void input_1_twice() {
        cut.set(1);
        int result = cut.firstBadVersion(1);
        assertEquals(1, result);
        result = cut.firstBadVersion(1);
        assertEquals(1, result);
    }

    @Test
    void input_2_twice() {
        cut.set(2);
        int result = cut.firstBadVersion(2);
        assertEquals(2, result);
        result = cut.firstBadVersion(2);
        assertEquals(2, result);
    }

    @Test
    void two_distant_inputs() {
        int firstBadVersion = 1702766719;
        cut.set(firstBadVersion);
        int result = cut.firstBadVersion(2126753390);
        assertEquals(firstBadVersion, result);
        result = cut.firstBadVersion(1702766719);
        assertEquals(firstBadVersion, result);
    }

    @Test
    void another_edge_case() {
        int firstBadVersion = 27814230;
        cut.set(firstBadVersion);
        int result = cut.firstBadVersion(131904690);
        assertEquals(firstBadVersion, result);
        result = cut.firstBadVersion(firstBadVersion);
        assertEquals(firstBadVersion, result);
    }
}
