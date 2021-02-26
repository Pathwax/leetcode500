package meituan;

import util.ListNode;

public class MT83_dev {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode tag = head;
        while(head!=null && head.next!=null){
            if (head.val==head.next.val)
                head.next = head.next.next;
            else head = head.next;
        }
        return tag;
    }
}
