package org.ryyaan2004.gprep.sort;

public class MergeSort {

    void sort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left)/2;
            sort(arr, left, mid);
            sort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    void merge(int[] arr, int left, int mid, int right) {
        int sizeLeft = mid - left + 1;
        int sizeRight = right - mid;

        int[] tmpLeft = new int[sizeLeft];
        int[] tmpRight = new int[sizeRight];

        for (int i = 0; i < sizeLeft; i++) {
            tmpLeft[i] = arr[left + i];
        }
        for (int i = 0; i < sizeRight; i++) {
            tmpRight[i] = arr[mid + 1 + i];
        }

        int indexLeft = 0, indexRight = 0;
        int indexMerged = left;

        while (indexLeft < sizeLeft && indexRight < sizeRight) {
            if ( tmpLeft[indexLeft] <= tmpRight[indexRight]) {
                arr[indexMerged] = tmpLeft[indexLeft];
                indexLeft++;
            } else {
                arr[indexMerged] = tmpRight[indexRight];
                indexRight++;
            }
            indexMerged++;
        }

        while ( indexLeft < sizeLeft) {
            arr[indexMerged] = tmpLeft[indexLeft];
            indexLeft++;
            indexMerged++;
        }

        while ( indexRight < sizeRight) {
            arr[indexMerged] = tmpRight[indexRight];
            indexRight++;
            indexMerged++;
        }
    }
}
