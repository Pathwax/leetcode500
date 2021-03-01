package YFD;

import util.ListNode;

// 排序链表 归并排序 递归法
public class YFD148_prod1 {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode fast = head.next, slow = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode tmp = slow.next;// 链表右半部分的头结点
        slow.next = null;// cut链表
        ListNode left = sortList(head);
        ListNode right = sortList(tmp);

        // 合并两个有序链表
        ListNode h = new ListNode(0);
        ListNode res = h;
        while(left != null && right != null){
            if (left.val < right.val){
                h.next = left;
                left = left.next;
            }else{
                h.next = right;
                right = right.next;
            }
            h = h.next;
        }
        h.next = left != null ? left : right;
        return res.next;
    }
}
