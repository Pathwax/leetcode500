package LCCI.chapter16;

import java.util.HashMap;
import java.util.Map;

public class LRUCache_prod2 {
    static class DLinkedNode {
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;

        public DLinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private int capacity;
    private Map<Integer, DLinkedNode> map;
    private DLinkedNode head, tail;

    public LRUCache_prod2(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>(capacity + 1);
        this.head = new DLinkedNode(-1, -1);
        this.tail = new DLinkedNode(-1, -1);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DLinkedNode node = map.get(key);
        if (node == null)
            return -1;
        moveToTail(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (get(key) != -1)
            map.get(key).value = value;
        else {
            DLinkedNode newNode = new DLinkedNode(key, value);
            map.put(key, newNode);
            addToTail(newNode);
            if (map.size() > capacity) {
                map.remove(head.next.key);
                removeNode(head.next);
            }
        }
    }

    private void moveToTail(DLinkedNode node) {
        removeNode(node);
        addToTail(node);
    }

    private void removeNode(DLinkedNode node) {
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }

    private void addToTail(DLinkedNode node) {
        node.prev = tail.prev;
        tail.prev = node;
        node.prev.next = node;
        node.next = tail;
    }

}
