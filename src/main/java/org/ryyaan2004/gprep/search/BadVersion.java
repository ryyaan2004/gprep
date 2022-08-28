package org.ryyaan2004.gprep.search;

import java.util.Arrays;

public class BadVersion {
    int firstBadVersion = Integer.MIN_VALUE;

    public int firstBadVersion(int n) {
        if (firstBadVersion == Integer.MIN_VALUE && n < 7) {
            firstBadVersion = Integer.MAX_VALUE;
            for (int i = 1; i <= 7; i++) {
                if (isBadVersion(i)) {
                    firstBadVersion = i;
                    break;
                }
            }
        }
        if (firstBadVersion != Integer.MIN_VALUE && n >= firstBadVersion) {
            return firstBadVersion;
        }
        firstBadVersion = binarySearch(n);
        return firstBadVersion;
    }

    int binarySearch(int upperBound){
        int left = 0, right = upperBound;
        int result = Integer.MAX_VALUE;
        int timesLooped = 0;
        while(left < right){
            if ( right - left == 1) {
                timesLooped++;
                if (timesLooped > 2) {
                    break;
                }
            }
            // Prevent (left + right) overflow
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                result = mid;
                right = mid;
            } else {
                left = mid;
            }
        }
        return result;
    }

    boolean isBadVersion(int n) {
        return false;
    }
}
