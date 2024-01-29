package com.dailycoder;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Optional;

public class LRUCache{

    private int capacity;
    private LinkedList<Integer> order = new LinkedList<>();
    private Map<Integer,Integer> map = new HashMap<>();

    public LRUCache(int size){
        this.capacity = size;
    }

    public int get(int key) {
        int res = map.get(key);
        if(res!=0){
            order.remove(key);
            order.addFirst(key);
        }else{
            res = -1;
        }

        return res;

    }

    public void put(int key, int value) {

        if(order.size()-1>=capacity){
            int keyToBeRemoved = order.remove(key);
            map.remove(keyToBeRemoved);
        }

        order.addFirst(key);
        map.put(key,value);

    }
}
