package YFD;

import util.ListNode;

public class YFD92_dev {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode tagFront = dummy;
        int count = right-left;
        while(left>1){
            tagFront = tagFront.next;
            left--;
        }
        tagFront.next = reverse(tagFront.next,count);
        return dummy.next;
    }
    private ListNode reverse(ListNode head, int count){
        if(head==null || head.next == null || count == 0){
            return head;
        }
        ListNode tag = reverse(head.next,count - 1);
        ListNode temp = head.next.next;
        head.next.next = head;
        head.next = temp;
        return tag;
    }
}
