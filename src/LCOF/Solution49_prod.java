package LCOF;

public class Solution49_prod {
    /**
     * 三个指针的移动类比于合并三个有序数组，有可能出现相等的情况去重所以没有else
     * @param n
     * @return
     */
    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        int index2 = 0, index3 = 0, index5 = 0;
        for(int i = 1; i < n; i++){
            int n1 = dp[index2] * 2, n2 = dp[index3] * 3, n3 = dp[index5] * 5;
            dp[i] = Math.min(n1,Math.min(n2,n3));
            if(dp[i]==n1) index2 ++;
            if(dp[i]==n2) index3 ++;
            if(dp[i]==n3) index5 ++;
        }
        return dp[n-1];
    }
}
