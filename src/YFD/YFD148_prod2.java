package YFD;

import util.ListNode;

// 排序链表 归并排序 迭代法
public class YFD148_prod2 {
    public ListNode sortList(ListNode head) {
        int length = getLength(head);
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        for (int step = 1; step < length; step *= 2) {// 依次将链表分成1块、2块、4块
            // 每次变换步长，pre指针和cur指针都初始化在链表头
            ListNode pre = dummy;
            ListNode cur = dummy.next;
            while(cur!=null){
                ListNode h1 = cur;// 第一部分头（第二次循环之后，cur为剩余部分头，不断往后把链表按照步长step分成一块一块。。。）
                ListNode h2 = split(h1,step);// 第二部分头
                cur = split(h2,step);// 剩余部分的头
                pre.next = merge(h1,h2);// 将前面的部分与排序好的部分连接
                while(pre.next!=null)
                    pre = pre.next;// 把pre指针移动到排序好的部分的末尾
            }
        }
        return dummy.next;
    }

    private int getLength(ListNode head){
        // 获取链表长度
        int count = 0;
        while(head!=null){
            count ++;
            head = head.next;
        }
        return count;
    }

    private ListNode split(ListNode head, int step){
        // 断链操作，返回第二部分链表头
        if (head == null) return null;
        ListNode cur = head;
        for (int i = 1; i < step && cur.next!=null; i++) {
            cur = cur.next;
        }
        ListNode right = cur.next;
        cur.next = null; // 切断连接
        return right;
    }

    private ListNode merge(ListNode h1, ListNode h2){
        // 合并两个有序链表
        ListNode head = new ListNode(-1);
        ListNode p = head;
        while(h1 != null && h2 != null){
            if (h1.val < h2.val) {
                p.next = h1;
                h1 = h1.next;
            }else{
                p.next = h2;
                h2 = h2.next;
            }
            p = p.next;
        }
        if (h1 != null) p.next = h1;
        if (h2 != null) p.next = h2;

        return head.next;
    }
}
