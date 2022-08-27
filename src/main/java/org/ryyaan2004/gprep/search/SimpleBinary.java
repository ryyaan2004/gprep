package org.ryyaan2004.gprep.search;

public class SimpleBinary {

    // simple, returns -1 if not found
    int binarySearch(int[] nums, int target) {
        if (nums == null || nums.length == 0) { return -1; }

        int left = 0, right = nums.length -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if ( nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
