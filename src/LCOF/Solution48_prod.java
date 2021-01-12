package LCOF;

public class Solution48_prod {
    public int lengthOfLongestSubstring(String s) {
        // 记录字符上一次出现的位置
        int[] last = new int[128];
        for (int i = 0; i < 128; i++) {
            last[i] = -1;
        }
        int len = s.length();
        int res = 0, start = 0; // 结果和窗口开始位置
        for (int i = 0; i < len; i++) {
            // 查找第i个字符是什么
            char index = s.charAt(i);
            start = Math.max(start,last[index]+1);
            res = Math.max(res,i-start+1);
            last[index] = i;
        }
        return res;
    }
}
