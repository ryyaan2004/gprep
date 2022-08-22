package org.ryyaan2004.gprep.hashtable;

// Learned a lesson from HashSet, now using the same name as the exercise, so I can paste over
public class MyHashMap {

    private class Node<K, V> {
        K key;
        V val;

        Node<K, V> next;

        public Node(K key, V val) {
            this.key = key;
            this.val = val;
        }
    }

    private final Node<Integer, Integer>[] buckets;
    private final int TABLE_SIZE = 10;

    public MyHashMap(){
        this.buckets = new Node[TABLE_SIZE];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = null;
        }
    }

    private int hash(int key) {
        return (31 * key) % TABLE_SIZE;
    }

    // insert key:value, if key exists update value
    public void put(int key, int value) {
        int idx = hash(key);
        Node<Integer, Integer> newNode = new Node<>(key, value);
        if (buckets[idx] == null) {
            buckets[idx] = newNode;
        } else {
            Node<Integer, Integer> curNode = buckets[idx];
            if (!containsKey(key)) {
                // append new
                while (curNode.next != null) {
                    curNode = curNode.next;
                }
                curNode.next = newNode;
            } else {
                // update in place
                while (curNode.key != key) {
                    curNode = curNode.next;
                }
                curNode.val = value;
            }
        }
    }

    private boolean containsKey(int key) {
        int idx = hash(key);
        Node<Integer, Integer> curNode = buckets[idx];
        if (curNode == null) {
            return false;
        }
        while (curNode != null) {
            if (curNode.key == key) {
               return true;
            }
            curNode = curNode.next;
        }
        return false;
    }

    // return the value associated with the key, or -1 if key not exists
    public int get(int key) {
        int idx = hash(key);
        Node<Integer,Integer> curNode = buckets[idx];
        while (curNode != null) {
            if (curNode.key == key) {
                return curNode.val;
            }
            curNode = curNode.next;
        }
        return -1;
    }

    // remove key:value pair, do nothing if key not exists
    public void remove(int key) {
        int idx = hash(key);
        Node<Integer,Integer> curNode = buckets[idx];
        if (curNode == null) {
            return;
        }
        Node<Integer,Integer> nextNode = curNode.next;
        if (curNode.key == key && nextNode == null) {
            buckets[idx] = null;
            return;
        }
        if (curNode.key == key && nextNode != null) {
            buckets[idx] = nextNode;
            return;
        }
        while ( nextNode != null) {
            if (nextNode.key == key) {
                curNode.next = nextNode.next;
                break;
            }
            curNode = nextNode;
            nextNode = nextNode.next;
        }
    }
}
