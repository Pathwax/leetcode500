package meituan;

import util.ListNode;

// k个一组翻转链表
public class MT25_prod {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode pre = dummy;
        ListNode end = dummy;

        while(end.next != null){
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }
            if (end == null) break;
            ListNode start = pre.next;
            ListNode next = end.next;
            end.next = null;
            pre.next = reverse(start);
            start.next = next;
            pre = start;
            end = pre;
        }
        return dummy.next;
    }

    private ListNode reverse(ListNode head){
        if(head == null || head.next == null)
            return head;
        ListNode tag = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return tag;
    }
}
