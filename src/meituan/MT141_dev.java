package meituan;

import util.ListNode;

public class MT141_dev {
    public boolean hasCycle(ListNode head) {
        boolean res = false;
        ListNode fast = head;
        ListNode slow = head;
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                res = true;
                break;
            }
        }
        return res;
    }
}
