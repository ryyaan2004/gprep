package org.ryyaan2004.gprep.stairclimbing;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SolutionTest {

    @Test
    void n_is_2(){
        Solution cut = new Solution();
        int result = cut.climbStairs(2);
        assertEquals(2, result);
    }

    @Test
    void n_is_3() {
        Solution cut = new Solution();
        int result = cut.climbStairs(3);
        assertEquals(3, result);
    }

    @Test
    void n_is_4() {
        Solution cut = new Solution();
        int result = cut.climbStairs(4);
        assertEquals(5, result);
    }

    @Test
    void n_is_5() {
        Solution cut = new Solution();
        int result = cut.climbStairs(5);
        assertEquals(8, result);
    }

    @Test
    void n_is_6() {
        Solution cut = new Solution();
        int result = cut.climbStairs(6);
        assertEquals(13, result);
    }
}

/*
f(n)
f(2) = 2
f(3) = 3

n = 4
1. 1 + 1 + 1 + 1
2. 2 + 2
3. 2 + 1 + 1
4. 1 + 2 + 1
5. 1 + 1 + 2

n = 5
1. 1 + 1 + 1 + 1 + 1
2. 1 + 1 + 1 + 2
3. 1 + 1 + 2 + 1
4. 1 + 2 + 1 + 1
5. 2 + 1 + 1 + 1
6. 2 + 2 + 1
7. 2 + 1 + 2
8 1 + 2 + 2

f(n) = f(n-1) + f(n-2)
 */