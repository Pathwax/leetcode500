package LCCI.chapter16;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class LRUCache_dev {
    Deque<Integer> dq;
    Map<Integer, Integer> map;
    int capacity;
    int count = 0;

    public LRUCache_dev(int capacity) {
        this.dq = new ArrayDeque<>(capacity);
        this.capacity = capacity;
        this.map = new HashMap<>(capacity);
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            dq.remove(key);
            dq.addLast(key);
            return map.get(key);
        } else
            return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            dq.remove(key);
            dq.addLast(key);
            map.put(key, value);
        } else {
            if (count == capacity) {
                if (capacity == 0) return;
                map.remove(dq.removeFirst());
                count--;
            }
            dq.addLast(key);
            map.put(key, value);
            count++;
        }
    }
}
