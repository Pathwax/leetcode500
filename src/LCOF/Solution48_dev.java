package LCOF;

import java.util.HashMap;
import java.util.Map;

public class Solution48_dev {
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        Map<Character,Integer> map = new HashMap<>();
        int[] dp = new int[len];
        int res = 0;
        for (int i = 0; i < len; i++) {
            char key = s.charAt(i);
            if (map.containsKey(key)){
                int distance = i - map.get(key);
                if (distance <= dp[i-1])
                    dp[i] = distance;
                else
                    dp[i] = dp[i-1] + 1;
            }else{
                dp[i] = i==0? 1 : dp[i-1] + 1;
            }
            map.put(key,i);
            res = Math.max(res,dp[i]);
        }
        return res;
    }
}
