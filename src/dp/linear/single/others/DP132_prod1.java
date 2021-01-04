package dp.linear.single.others;

import java.util.Arrays;

public class DP132_prod1 {
    public int minCut(String s) {
        if (s==null||s.length()<=1) return 0;
        int len = s.length();
        int dp[] = new int[len];
        Arrays.fill(dp,len-1);
        for (int i = 0; i < len; i++) {
            minCutHelper(s,i,i,dp); // 奇数回文串以1个字符为中心
            minCutHelper(s,i,i+1,dp); // 偶数回文串以2个字符为中心
        }
        return dp[len-1];
    }
    private void minCutHelper(String s, int i, int j, int[] dp){
        int len = s.length();
        while(i>=0&&j<len&&s.charAt(i)==s.charAt(j)){
            dp[j] = Math.min(dp[j],(i==0?-1:dp[i-1])+1);
            i--;j++;
        }
    }
}
