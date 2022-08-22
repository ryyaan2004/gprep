package org.ryyaan2004.gprep.hashtable;

public class HashSet implements IHashSet {

    private final int[][] buckets;

    private final int TABLE_SIZE = 10;
    private final int BUCKET_SIZE_INCREMENT = 10;

    private final int DEFAULT_VALUE = Integer.MIN_VALUE;

    public HashSet() {
        this.buckets = new int[TABLE_SIZE][];
        for (int i = 0; i < TABLE_SIZE; i++) {
            int[] bucket = new int[BUCKET_SIZE_INCREMENT];
            for (int k = 0; k < BUCKET_SIZE_INCREMENT; k++) {
                bucket[k] = DEFAULT_VALUE;
            }
            this.buckets[i] = bucket;
        }
    }

    private int hash(int val) {
        return (val * 31) % TABLE_SIZE;
    }

    private void resize(int bucketIdx) {
        int curLen = buckets[bucketIdx].length;
        int[] bucket = new int[curLen + BUCKET_SIZE_INCREMENT];
        for (int i = 0; i < curLen; i++) {
            bucket[i] = buckets[bucketIdx][i];
        }

        for (int i = curLen; i < curLen + BUCKET_SIZE_INCREMENT; i++) {
            bucket[i] = DEFAULT_VALUE;
        }

        buckets[bucketIdx] = bucket;
    }

    private void ensureCapacity(int bucketIdx) {
        int[] bucket = buckets[bucketIdx];
        if (DEFAULT_VALUE != bucket[bucket.length - 1]) {
            resize(bucketIdx);
        }
    }

    @Override
    public void add(final int key) {
        int idx = hash(key);
        if (!contains(key)) {
            ensureCapacity(idx);
            int[] bucket = buckets[idx];
            for(int i = 0; i < bucket.length; i++) {
                if (bucket[i] == DEFAULT_VALUE) {
                    bucket[i] = key;
                    break;
                }
            }
        }
    }

    @Override
    public boolean contains(int key) {
        int idx = hash(key);
        int[] bucket = buckets[idx];
        for (int i = 0; i < bucket.length; i++) {
            if (bucket[i] == key) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void remove(int key) {
        if (contains(key)) {
            int idx = hash(key);
            int[] bucket = buckets[idx];
            for (int i = 0; i < bucket.length; i++) {
                if (bucket[i] == key) {
                    frontLoad(bucket, i);
                    break;
                }
            }
        }
    }

    public void frontLoad(int[] bucket, int start) {
        for ( int i = start + 1; i < bucket.length; i++) {
            bucket[i-1] = bucket[i];
            bucket[i] = DEFAULT_VALUE;
        }
    }
}
