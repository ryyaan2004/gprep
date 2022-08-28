package org.ryyaan2004.gprep.stairclimbing;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    Map<Integer,Integer> computed = new HashMap<>();
    public Solution() {
        computed.put(1, 1);
        computed.put(2,2);
    }
    public int climbStairs(int n) {
        if (computed.containsKey(n)) {
            return computed.get(n);
        }
        int val = climbStairs(n-1) + climbStairs(n-2);
        computed.put(n, val);
        return val;
    }
}
