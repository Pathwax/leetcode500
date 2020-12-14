package meituan;

import java.util.HashMap;
import java.util.Map;

public class MT3_prod2 {
    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        int res = 0, left = 0;
        for (int i = 0; i < chars.length; i++) {
            if (map.containsKey(chars[i]))
                left = Math.max(left,map.get(chars[i])+1);
            map.put(chars[i],i);
            res = Math.max(res,i-left+1);
        }
        return res;
    }
}
