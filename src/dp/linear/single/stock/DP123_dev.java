package dp.linear.single.stock;

public class DP123_dev {
    public int maxProfit(int[] prices) {
        int N = prices.length;
        int[][][] dp = new int[N][3][2];
        dp[0][1][0] = 0;
        dp[0][1][1] = -prices[0];
        dp[0][2][0] = 0;
        dp[0][2][1] = -prices[0];
        for (int i = 1; i < N; i++) {
            for (int k = 1; k < 3; k++) {
                dp[i][k][0] = Math.max(dp[i-1][k][0],dp[i-1][k][1]+prices[i]);
                dp[i][k][1] = Math.max(dp[i-1][k][1],dp[i-1][k-1][0]-prices[i]);
            }
        }
        return dp[N-1][2][0];
    }
}
