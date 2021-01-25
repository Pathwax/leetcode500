package dp.linear.single.stock;

public class DP188_dev {
    public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length == 0)
            return 0;
        int N = prices.length;
        int[][][] dp = new int[N][k + 1][2];
        // 初始化
        for (int i = 0; i <= k; i++) {
            dp[0][i][0] = 0;
            dp[0][i][1] = -prices[0];
        }
        // for (int i = 0; i < N; i++) {
        //     dp[i][0][0] = 0;
        //     dp[i][0][1] = Integer.MIN_VALUE;
        // }
        // 状态转移
        for (int i = 1; i < N; i++) {
            for (int j = 1; j <= k; j++) {
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
            }
        }
        // 返回结果
        return dp[N - 1][k][0];
    }
}
