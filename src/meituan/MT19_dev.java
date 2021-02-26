package meituan;

import util.ListNode;

public class MT19_dev {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow = head, fast = head;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        while (fast!=null && fast.next!=null){
            fast = fast.next;
            slow = slow.next;
        }
        if (fast==null) return slow.next;
        ListNode temp = slow.next.next;
        slow.next.next = null;
        slow.next = temp;
        return head;
    }
}
