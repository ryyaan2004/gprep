package org.ryyaan2004.gprep.hashtable;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class HashSetTest {

    @Test
    void handles_zero() {
        HashSet h = new HashSet();
        h.add(58);
        boolean e = h.contains(0);
        assertFalse(e);
    }

    @Test
    void given_test() {
        HashSet h = new HashSet();
        h.add(1);
        h.add(2);
        assertTrue(h.contains(1));
        assertFalse(h.contains(3));
        h.add(2);
        assertTrue(h.contains(2));
        h.remove(2);
        assertFalse(h.contains(2));
    }

    @Test
    void fails_for_some_reason() {
        // the reason was that I forgot to copy my constructor changes to leetcode >:|
        HashSet h = new HashSet();
        h.add(58);
        assertFalse(h.contains(0));
        h.add(14);
        assertTrue(h.contains(58));
        h.remove(91);
        h.add(6);
        assertTrue(h.contains(58));
        h.add(66);
        h.add(51);
        h.add(16);
        h.add(40);
        h.add(52);
        h.add(48);
        assertTrue(h.contains(40));
        h.add(42);
        h.add(85);
        h.add(36);
        assertTrue(h.contains(16));
        h.remove(0);
        assertFalse(h.contains(43));
        assertTrue(h.contains(6));
        h.add(3);
        h.remove(25);
        h.add(99);
        h.remove(66);
        h.add(60);
        h.remove(58);
        h.add(97);
        assertTrue(h.contains(3));
        h.add(35);
        h.add(65);
        assertTrue(h.contains(40));
        h.add(41);
        h.add(10);
        h.add(37);
        h.add(65);
        h.remove(37);
        assertTrue(h.contains(40));
        h.add(28);
        assertTrue(h.contains(60));
        h.add(30);
        h.add(63);
        h.add(76);
        h.remove(90);
        h.remove(3);
        h.add(43);
        assertFalse(h.contains(81));
        h.add(61);
        h.add(39);
        assertFalse(h.contains(75));
        h.remove(10);
        h.add(55);
        assertFalse(h.contains(92));
        h.add(71);
        h.remove(2);
        h.remove(20);
        h.add(7);
        assertTrue(h.contains(55));
        h.add(88);
        assertTrue(h.contains(39));
        assertTrue(h.contains(97));
        h.add(44);
        h.add(1);
        h.remove(51);
        h.remove(89);
        h.add(37);
        h.remove(19);
        h.add(3);
        h.add(13);
        h.add(11);
        h.add(68);
        h.add(18);
        h.add(17);
        h.remove(41);
        h.remove(87);
        h.add(48);
        h.remove(43);
        h.add(68);
        h.add(80);
        h.add(35);
        h.add(2);
        assertTrue(h.contains(17));
        h.add(71);
        h.remove(90);
        h.remove(83);
        h.remove(42);
        h.remove(88);
        h.add(16);
        h.add(37);
        h.add(33);
        h.add(66);
        assertFalse(h.contains(59));
        h.add(6);
        h.add(79);
        h.add(77);
        h.add(14);
        h.add(69);
        h.add(36);
        h.add(21);
        h.add(40);
    }
}
