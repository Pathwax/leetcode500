package YFD;

import util.ListNode;

public class YFD328_dev {
    public ListNode oddEvenList(ListNode head) {
        ListNode dummyEven = new ListNode();
        ListNode dummyOdd = new ListNode();
        ListNode tagEven = dummyEven;
        ListNode tagOdd = dummyOdd;
        boolean isEven = true;
        while(head != null){
            if(isEven){
                dummyEven.next = head;
                dummyEven = dummyEven.next;
            }else{
                dummyOdd.next = head;
                dummyOdd = dummyOdd.next;
            }
            head = head.next;
            isEven = !isEven;
        }
        dummyEven.next = tagOdd.next;
        dummyOdd.next = null;
        return tagEven.next;
    }
}
