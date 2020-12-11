package LCCI.chapter16;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache_prod1 extends LinkedHashMap<Integer,Integer> {
    private int capacity;

    public LRUCache_prod1(int capacity) {
        super(capacity,0.75F,true);
        this.capacity = capacity;
    }

    public int get(int key){
        return super.getOrDefault(key,-1);
    }

    public void put(int key,int value){
        super.put(key,value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        return size()>capacity;
    }
}
