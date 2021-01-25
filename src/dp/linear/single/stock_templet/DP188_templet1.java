package dp.linear.single.stock_templet;

// 情况四，通用情况。
// 对交易次数的循环使用反向循环是为了避免使用临时变量。
// 经过实验，正向也可以。
public class DP188_templet1 {
    public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int N = prices.length;
        // 每天都交易时已经是最大，允许最大交易量再大也无关紧要。（一次交易代表一个买入和卖出的组合）
        if (k >= N / 2) {
            return maxProfit(prices);
        }
        int[][][] dp = new int[N][k + 1][2];
        for (int i = 1; i <= k; i++) {
            dp[0][i][0] = 0;
            dp[0][i][1] = -prices[0];
        }
        for (int i = 1; i < N; i++) {
            for (int j = k; j > 0; j--) {
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
            }
        }
        return dp[N - 1][k][0];
    }

    public int maxProfit(int[] prices) {
        int N = prices.length;
        int[][] dp = new int[N][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < N; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[N - 1][0];
    }
}
