package com.changework;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

class LRUCache {
    private LinkedList<Integer> linkedList;
    private Map<Integer, Integer> map;

    private int max_size;
    private int cur_size = 0;

    public LRUCache(int capacity) {
        linkedList = new LinkedList<>();
        map = new HashMap<>();
        this.max_size = capacity;
    }

    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }

        int val = map.get(key);
        Object o = key;
        linkedList.remove(o);
        linkedList.addFirst(key);
        return val;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            // 这个put不能省略，即时key存在，若新添加的value更新了，那刚好就将value更新，如果省略，则value更新不了
            map.put(key, value);
            Object o = key;
            linkedList.remove(o);
            linkedList.addFirst(key);
        }else{
            map.put(key, value);
            cur_size++;
            linkedList.addFirst(key);
            if(cur_size>max_size){
                int tmp = linkedList.removeLast();
                map.remove(tmp);
                cur_size--;
            }
        }
    }
}