package org.ryyaan2004.gprep.search;

public class PeakElements {
    public int findPeakElement(int[] nums) {
        return binarySearch(nums);
    }

    int binarySearch(int[] arr) {
        if (arr == null) {
            return -1;
        }
        int maxValue = arr[0];
        int maxIndex = 0;
        int left = 0, right = arr.length - 1;
        int range = arr.length / 5;
        if ( range < 5) {
            range = 5;
        }
        while (left < right) {
            int mid = left + (right - left)/2;
            int[] comparison = iterativeSearch(arr, mid - range, mid + range);
            if (comparison[0] > maxValue) {
                maxValue = comparison[0];
                maxIndex = comparison[1];
            } else {
                left = mid + 1;
            }
        }
        return maxIndex;
    }

    int[] iterativeSearch(int[] arr, int lower, int upper) {
        int[] results = new int[2];
        if (arr == null) {
            results[0] = -1;
            results[1] = -1;
            return results;
        }
        if (lower < 0) {
            lower = 0;
        }
        if (upper >= arr.length) {
            upper = arr.length - 1;
        }
        int max = Integer.MIN_VALUE;
        int maxIndex = lower;
        for (int i = lower; i <= upper; i++) {
            if (arr[i] > max) {
                max = arr[i];
                maxIndex = i;
            }
        }
        results[0] = max;
        results[1] = maxIndex;
        return results;
    }

}
