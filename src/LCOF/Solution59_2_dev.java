package LCOF;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Solution59_2_dev {
    Queue<Integer> queue;
    Deque<Integer> deque;

    public Solution59_2_dev() {
        this.deque = new LinkedList<>();
        this.queue = new LinkedList<>();
    }

    public int max_value() {
        if (deque.isEmpty())
            return -1;
        return deque.peekFirst();
    }

    public void push_back(int value) {
        queue.offer(value);
        while(!deque.isEmpty()&&deque.peekLast()<value){
            deque.pollLast();
        }
        deque.offerLast(value);
    }

    public int pop_front() {
        if (queue.isEmpty())
            return -1;
        int element = queue.poll();
        if (element==deque.peekFirst())
            deque.pollFirst();
        return element;
    }
}
