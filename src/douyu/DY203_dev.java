package douyu;

import util.ListNode;

public class DY203_dev {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode tag = dummy;
        while(head!=null){
            if(head.val == val){
                tag.next = head.next;
            }else{
                tag = tag.next;
            }
            head = head.next;
        }
        return dummy.next;
    }
}
