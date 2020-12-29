package dp.linear.single.others;

import java.util.ArrayDeque;
import java.util.Deque;

public class DP32_prod1 {
    public int longestValidParentheses(String s) {
        char[] chars = s.toCharArray();
        Deque<Integer> deque = new ArrayDeque<>();
        int[] mark = new int[s.length()];
        for (int i = 0; i < chars.length; i++) {
            if (chars[i]=='(')
                deque.push(i);
            else{
                if (deque.isEmpty())
                    mark[i] = 1;
                else
                    deque.pop();
            }
        }
        while(!deque.isEmpty()){
            mark[deque.pop()] = 1;
        }
        int res = 0;
        int len = 0;
        for (int tag : mark) {
            if (tag == 0) {
                len++;
                res = Math.max(res, len);
            }
            if (tag == 1)
                len = 0;
        }
        return res;
    }
}
