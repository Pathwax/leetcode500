package LCCI.chapter16;

import java.util.HashMap;
import java.util.Map;

public class LFUCache_dev {

    class Level {
        int id;
        Level lower;
        Level higher;
        DLinkedNode head, tail;

        public Level(int frequency) {
            this.id = frequency;
            this.head = new DLinkedNode(-1, -1);
            this.tail = new DLinkedNode(-1, -1);
            head.next = tail;
            tail.prev = head;
        }

        void removeNode(DLinkedNode node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        void insertNode(DLinkedNode node) {
            node.prev = tail.prev;
            node.next = tail.prev.next;
            tail.prev.next = node;
            tail.prev = node;
            node.onLevel = this;
        }

        boolean isEmpty() {
            return this.head.next == this.tail;
        }

    }

    class DLinkedNode {
        int key;
        int value;
        Level onLevel;
        DLinkedNode prev;
        DLinkedNode next;

        public DLinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    int capacity;
    Map<Integer, DLinkedNode> map;
    Level bottom, top;

    public LFUCache_dev(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>(capacity);
        this.bottom = new Level(0);
        this.top = new Level(-1);
        bottom.higher = top;
        top.lower = bottom;
    }

    public int get(int key) {
        DLinkedNode node = map.get(key);
        if (node == null)
            return -1;
        changeLevel(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (capacity == 0) return;
        if (get(key) != -1)
            map.get(key).value = value;
        else {
            if (map.size() == capacity) {
                Level targetLevel = bottom.higher;
                DLinkedNode targetNode = targetLevel.head.next;
                map.remove(targetNode.key);
                targetLevel.removeNode(targetNode);
                if (targetLevel.isEmpty())
                    removeLevel(targetLevel);
            }
            DLinkedNode newNode = new DLinkedNode(key, value);
            map.put(key, newNode);
            if (bottom.higher.id != 1) {
                Level newLevel = new Level(1);
                insertLevel(bottom, newLevel);
                newLevel.insertNode(newNode);
            } else
                bottom.higher.insertNode(newNode);
        }
    }

    // 注意顺序
    private void changeLevel(DLinkedNode node) {
        Level oldLevel = node.onLevel;
        oldLevel.removeNode(node);
        if (oldLevel.higher.id == oldLevel.id + 1) {
            oldLevel.higher.insertNode(node);
        } else {
            Level newLevel = new Level(oldLevel.id + 1);
            insertLevel(oldLevel, newLevel);
            newLevel.insertNode(node);
        }
        if (oldLevel.isEmpty())
            removeLevel(oldLevel);
    }

    private void removeLevel(Level level) {
        level.lower.higher = level.higher;
        level.higher.lower = level.lower;
    }

    private void insertLevel(Level preLevel, Level newLevel) {
        newLevel.higher = preLevel.higher;
        newLevel.lower = preLevel;
        preLevel.higher.lower = newLevel;
        preLevel.higher = newLevel;
    }

}
