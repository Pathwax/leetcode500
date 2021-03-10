package meituan;

import util.ListNode;

public class MT445_test {
    public static void main(String[] args) {
        MT445_dev dev = new MT445_dev();
        ListNode listNode1 = new ListNode(0);
        ListNode tag = listNode1;
        tag.next = new ListNode(7);
        tag = tag.next;
        tag.next = new ListNode(2);
        tag = tag.next;
        tag.next = new ListNode(4);
        tag = tag.next;
        tag.next = new ListNode(3);
        tag = tag.next;
        ListNode listNode2 = new ListNode(0);
        tag = listNode2;
        tag.next = new ListNode(5);
        tag = tag.next;
        tag.next = new ListNode(6);
        tag = tag.next;
        tag.next = new ListNode(4);
        tag = tag.next;
        dev.addTwoNumbers(listNode1.next, listNode2.next);
    }
}
