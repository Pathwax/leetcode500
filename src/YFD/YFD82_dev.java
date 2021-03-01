package YFD;

import util.ListNode;

public class YFD82_dev {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy, fast = head;
        while(fast != null && fast.next != null){
            if(fast.next.val != fast.val){
                slow = slow.next;
            }else{
                while(fast.next!=null && fast.val == fast.next.val)
                    fast = fast.next;
                slow.next = fast.next;
            }
            fast = fast.next;
        }
        return dummy.next;
    }
}
