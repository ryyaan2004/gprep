package org.ryyaan2004.gprep.hashtable;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class MyHashMapTest {
    @Test
    void basic_test() {
        MyHashMap h = new MyHashMap();
        h.put(1,1);
        h.put(2,2);
        int a = h.get(1);
        assertEquals(a,1);
        a = h.get(3);
        assertEquals(a, -1);
        h.put(2,1);
        a = h.get(2);
        assertEquals(a, 1);
        h.remove(2);
        a = h.get(2);
        assertEquals(a, -1);
    }
}
