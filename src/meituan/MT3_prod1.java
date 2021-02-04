package meituan;

import java.util.HashMap;
import java.util.Map;

// 滑动窗口
public class MT3_prod1 {
    public int lengthOfLongestSubstring(String s){
        if (s.length()==0) return 0;
        Map<Character,Integer> map = new HashMap<>();
        int res = 0, left = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))){
                left = Math.max(left,map.get(s.charAt(i))+1);
            }
            map.put(s.charAt(i),i);
            res = Math.max(res,i-left+1);
        }
        return res;
    }
}
