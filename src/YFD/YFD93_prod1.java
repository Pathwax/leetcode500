package YFD;

import java.util.ArrayList;
import java.util.List;

// 复原IP地址
public class YFD93_prod1 {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        StringBuilder ip = new StringBuilder();
        for (int a = 1; a < 4; a++) {
            for (int b = 1; b < 4; b++) {
                for (int c = 1; c < 4; c++) {
                    for (int d = 1; d < 4; d++) {
                        if (a + b + c + d == s.length()){
                            if (judgeIpSegment(s, 0, a) && judgeIpSegment(s, a, a + b)
                                    && judgeIpSegment(s, a + b, a + b + c) && judgeIpSegment(s, a + b + c, a + b + c + d)){
                                ip.append(s, 0, a).append('.')
                                        .append(s, a, a+b).append('.')
                                        .append(s, a+b, a+b+c).append('.')
                                        .append(s, a+b+c, a+b+c+d);
                                res.add(ip.toString());
                                ip.delete(0,ip.length());
                            }
                        }
                    }
                }
            }
        }
        return res;
    }
    private boolean judgeIpSegment(String s,int left,int right){
        int len = right - left;
        if (len>1 && s.charAt(left)=='0') return false;
        int res = 0;
        while(left < right){
            res = res * 10 + s.charAt(left) - '0';
            left++;
        }
        return res >= 0 && res <= 255;
    }
}
