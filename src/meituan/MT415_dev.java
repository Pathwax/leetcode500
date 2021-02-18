package meituan;

import java.util.ArrayDeque;
import java.util.Deque;

public class MT415_dev {
    public String addStrings(String num1, String num2) {
        int m = num1.length();
        int n = num2.length();
        Deque<Character> dq = new ArrayDeque<>();
        int up = 0;
        while(m>0&&n>0){
            int digit = num1.charAt(m - 1) - '0' + num2.charAt(n - 1) - '0';
            int retain = (digit + up) % 10;
            dq.push((char) (retain + '0'));
            up = (digit + up) / 10;
            m--;
            n--;
        }
        while(m>0){
            int digit = num1.charAt(m - 1) - '0';
            int retain = (digit + up) % 10;
            dq.push((char) (retain + '0'));
            up = (digit + up) / 10;
            m--;
        }
        while(n>0){
            int digit = num2.charAt(n - 1) - '0';
            int retain = (digit + up) % 10;
            dq.push((char) (retain + '0'));
            up = (digit + up) / 10;
            n--;
        }
        StringBuilder sb = new StringBuilder(Math.max(m,n)+1);
        while(!dq.isEmpty()){
            sb.append(dq.pop());
        }
        return sb.toString();
    }
}
