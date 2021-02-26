package meituan;

import util.ListNode;

import java.util.PriorityQueue;

public class MT23_dev {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = new ListNode(0), temp = head;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int count = 0;
        while(count!=lists.length){
            for (int i = 0; i < lists.length; i++) {
                if (lists[i]!=null){
                    queue.add(lists[i].val);
                    lists[i] = lists[i].next;
                }else{
                    count++;
                }
            }
            if(!queue.isEmpty()){
                temp.next = new ListNode(queue.poll());
                temp = temp.next;
            }

            if (count!=lists.length) count = 0;
        }
        while(!queue.isEmpty()){
            temp.next = new ListNode(queue.poll());
            temp = temp.next;
        }
        return head.next;
        // if (lists == null || lists.length == 0) return null;
        // PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
        //     @Override
        //     public int compare(ListNode o1, ListNode o2) {
        //         if (o1.val < o2.val) return -1;
        //         else if (o1.val == o2.val) return 0;
        //         else return 1;
        //     }
        // });
        // ListNode dummy = new ListNode(0);
        // ListNode p = dummy;
        // for (ListNode node : lists) {
        //     if (node != null) queue.add(node);
        // }
        // while (!queue.isEmpty()) {
        //     p.next = queue.poll();
        //     p = p.next;
        //     if (p.next != null) queue.add(p.next);
        // }
        // return dummy.next;
    }
}
