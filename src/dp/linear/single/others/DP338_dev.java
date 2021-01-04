package dp.linear.single.others;

public class DP338_dev {
    public int[] countBits(int num) {
        int[] dp = new int[num+1];
        for (int i = 0; i <= num; i++) {
            if (i==0) dp[i] = 0;
            else dp[i] = i%2==0?dp[i/2]:dp[i-1]+1;
        }
        return dp;
    }
}
