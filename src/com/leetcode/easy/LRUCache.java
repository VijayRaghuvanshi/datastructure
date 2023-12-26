package com.leetcode.easy;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class LRUCache extends LinkedHashMap<Integer, Integer> {
    private int cacheSize;

    public LRUCache(int capacity) {
        super(capacity,0.75f, true);
        this.cacheSize = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > cacheSize;
    }
}
