package YFD;

import util.ListNode;

public class YFD148_prod3 {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        int minValue = Integer.MAX_VALUE;
        int maxValue = Integer.MIN_VALUE;
        ListNode cur = head;
        while(cur != null){
            minValue = Math.min(minValue, cur.val);
            maxValue = Math.max(maxValue, cur.val);
            cur = cur.next;
        }
        cur = head;
        int[] map = new int[maxValue - minValue + 1];// 记录每个元素出现的次数
        while(cur != null){
            map[cur.val - minValue]++;
            cur = cur.next;
        }
        cur = head;
        for(int i = 0; i < map.length; i++){
            for(int j = 0; j < map[i]; j++){
                cur.val = i + minValue;
                cur = cur.next;
            }
        }
        return head;
    }
}
