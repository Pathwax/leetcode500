package meituan;

import util.ListNode;

import java.util.Deque;
import java.util.LinkedList;

// 改进：头插法
public class MT445_dev {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Deque<Integer> stackL1 = new LinkedList<>();
        Deque<Integer> stackL2 = new LinkedList<>();
        ListNode tag1 = l1, tag2 = l2;
        while(tag1!=null){
            stackL1.push(tag1.val);
            tag1 = tag1.next;
        }
        while(tag2!=null){
            stackL2.push(tag2.val);
            tag2 = tag2.next;
        }
        Deque<Integer> stackL3 = new LinkedList<>();
        int carry = 0;
        while(!stackL1.isEmpty()&&!stackL2.isEmpty()){
            int num = carry+stackL1.pop()+stackL2.pop();
            stackL3.push(num%10);
            carry = num/10;
        }
        while(!stackL1.isEmpty()){
            int num = carry+stackL1.pop();
            stackL3.push(num%10);
            carry = num/10;
        }
        while(!stackL2.isEmpty()){
            int num = carry+stackL2.pop();
            stackL3.push(num%10);
            carry = num/10;
        }
        if(carry != 0)
            stackL3.push(carry);
        ListNode dummy = new ListNode(0);
        ListNode tag = dummy;
        while(!stackL3.isEmpty()){
            tag.next = new ListNode(stackL3.pop());
            tag = tag.next;
        }
        return dummy.next;
    }
}
