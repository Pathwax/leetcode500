package dp.linear.single.stock_templet;

// 如果要在第 i 天买入股票，第二个状态转移方程中就不能使用 T[i - 1][k][0]，而应该使用 T[i - 2][k][0]
public class DP309_templet1 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int N = prices.length;
        int[][] dp = new int[N][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < N; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], (i >= 2 ? dp[i - 2][0] : 0) - prices[i]);
        }
        return dp[N - 1][0];
    }
}
