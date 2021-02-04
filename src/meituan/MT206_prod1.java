package meituan;

import util.ListNode;

/**
 * 反转链表 递归解法
 */
public class MT206_prod1 {
    public ListNode reverseList(ListNode head) {
        //递归终止条件是当前为空，或者下一个节点为空
        if (head==null || head.next==null){
            return head;
        }
        //这里的cur就是最后一个节点
        ListNode cur = reverseList(head.next);
        head.next.next = head;
        //防止链表循环，需要将head.next设置为空
        head.next = null;
        //每层递归函数都返回cur，也就是最后一个节点
        return cur;
    }
}
