package dp.linear.single.stock;

public class DP714_dev {
    public int maxProfit(int[] prices, int fee) {
        int N = prices.length;
        int[][] dp = new int[N][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for(int i = 1; i < N; i++){
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]+prices[i]-fee);
            dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0]-prices[i]);
        }
        return dp[N-1][0];
    }
}
