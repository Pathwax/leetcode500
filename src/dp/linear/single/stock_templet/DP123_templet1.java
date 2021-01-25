package dp.linear.single.stock_templet;

// 情况三和情况一相似。区别在于：对于情况三，每天有四个未知变量：T[i][1][0]、T[i][1][1]、T[i][2][0]、T[i][2][1]
// 基准情况：
//     T[-1][k][0] = 0, T[-1][k][1] = -Infinity
//     T[i][0][0] = 0, T[i][0][1] = -Infinity
//     所以T[i][0][0],T[i][0][1]已知。第0天的情况（dp初值）可以由基准情况和递推公式推出。
public class DP123_templet1 {
    public int maxProfit(int[] prices) {
        int N = prices.length;
        int[][][] dp = new int[N][3][2];
        dp[0][1][0] = 0;
        dp[0][1][1] = -prices[0];
        dp[0][2][0] = 0;
        dp[0][2][1] = -prices[0];
        for (int i = 1; i < N; i++) {
            dp[i][1][0] = Math.max(dp[i-1][1][0],dp[i-1][1][1] + prices[i]);
            dp[i][1][1] = Math.max(dp[i-1][1][1],dp[i-1][0][0] - prices[i]);
            dp[i][2][0] = Math.max(dp[i-1][2][0],dp[i-1][2][1] + prices[i]);
            dp[i][2][1] = Math.max(dp[i-1][2][1],dp[i-1][1][0] - prices[i]);
        }
        return dp[N-1][2][0];
    }
}
