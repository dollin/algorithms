package org.elvaston.leetcode.problems;

import org.elvaston.leetcode.difficulty.hard;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * https://leetcode.com/problems/lru-cache/
 *
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.
 *
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * put(key, value) - Set or insert the value if the key is not already present.
 * When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
 */
@hard
public class lru_cache {

    static class QuantCastLRUCache {

        private final int capacity;
        Map<String, Integer> elements = new HashMap<>();
        Deque<String> counts = new LinkedList<>();

        QuantCastLRUCache(int capacity) {
            this.capacity = capacity;
        }

        public Integer get(String key) {
            counts.remove(key);
            counts.add(key);
            return elements.get(key);
        }

        public void put(String key, Integer value) {
            counts.remove(key);
            if (counts.size() == capacity) {
                String rmKey = counts.removeFirst();
                elements.remove(rmKey);
            }
            counts.add(key);
            elements.put(key, value);
        }
    }

    static class LRUCache {

        private final int[] keys;
        private final int[] values;
        private final int[] hits;
        private int counter = 1;

        public LRUCache(int capacity) {
            keys = new int[capacity + 1];
            values = new int[capacity + 1];
            for (int i = 0; i < values.length; i++) {
                values[i] = -1;
            }
            hits = new int[capacity + 1];
        }

        public int get(int key) {
            for (int i = 1; i < values.length; i++) {
                if (keys[i] == key) {
                    hits[i] = counter++;
                    return values[i];
                }
            }
            return -1;
        }

        public void put(int key, int value) {
            //add into an empty slot
            for (int i = 1; i < values.length; i++) {
                if (values[i] == -1 || keys[i] == key) {
                    keys[i] = key;
                    values[i] = value;
                    hits[i] = counter++;
                    return;
                }
            }
            //replace the lru
            int index = 0;
            int min_hits = counter;
            for (int i = 1; i < hits.length; i++) {
                if (hits[i] < min_hits) {
                    min_hits = hits[i];
                    index = i;
                }
            }
            keys[index] = key;
            values[index] = value;
            hits[index] = counter++;
        }
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(2,1);
        cache.put(2,2);
        System.out.println("2=" + cache.get(2));
        cache.put(1,1);
        cache.put(4,1);
        System.out.println("-1=" + cache.get(2));

        QuantCastLRUCache qcache = new QuantCastLRUCache(2);
        qcache.put("2",1);
        qcache.put("2",2);
        System.out.println("2=" + qcache.get("2"));
        qcache.put("1",1);
        qcache.put("4",1);
        System.out.println("-1=" + qcache.get("2"));
    }
}
