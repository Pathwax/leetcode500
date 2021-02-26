package meituan;

import java.util.ArrayDeque;
import java.util.Deque;

// 找到数组中的第K个最大元素
public class MT215_dev {
    public int findKthLargest(int[] nums, int k) {
        Deque<Integer> deque = new ArrayDeque<>(k);
        for (int num : nums) {
            if (deque.isEmpty()) deque.push(num);
            else if (deque.peek() > num && deque.size() < k)
                deque.push(num);
            else if (deque.peek() < num && deque.size() < k){
                Deque<Integer> temp = new ArrayDeque<>();
                while(!deque.isEmpty() && deque.peek() < num){
                    temp.push(deque.pop());
                }
                deque.push(num);
                while(!temp.isEmpty()){
                    deque.push(temp.pop());
                }
            }
            else if (deque.peek() < num && deque.size() == k){
                deque.pop();
                Deque<Integer> temp = new ArrayDeque<>();
                while(!deque.isEmpty() && deque.peek() < num){
                    temp.push(deque.pop());
                }
                deque.push(num);
                while(!temp.isEmpty()){
                    deque.push(temp.pop());
                }
            }
        }
        return deque.peek();
    }
}
