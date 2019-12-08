package com.example.study;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache extends LinkedHashMap<Integer,Integer>{

    private int capacity;

    public LRUCache(int capacity) {
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);

    }

    public void put(int key, int value) {
        super.put(key, value);

    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer,Integer> eldest) {
        return size() > capacity;
    }

    public static void main(String[] args) {
        LinkedHashMap<Integer, Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(1, 1);
        linkedHashMap.put(3, 3);
        linkedHashMap.put(2,2);

        LinkedHashMap<Integer, Integer> linkedHashMap1 = new LinkedHashMap<>(4, 0.75f, true);
        linkedHashMap1.put(1, 1);
        linkedHashMap1.put(3, 3);
        linkedHashMap1.put(2,2);
        linkedHashMap1.get(3);
        System.out.println(linkedHashMap);
        System.out.println(linkedHashMap1);
    }
}
