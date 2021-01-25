package dp.linear.single.stock_templet;

/**
 *
 * 参数1： i 表示第 i 天（i 的取值范围是 0 到 n - 1）。
 * 参数2： k 表示允许的 最大 交易次数。每次交易包含两次成对的操作，买入和卖出。只有买入操作会改变允许的最大交易次数。
 * 参数： T[i][k] 表示在第 i 天结束时，最多进行 k 次交易的情况下可以获得的最大收益。
 * 参数3： 持有股票的数量，0或1
 *
 * 基准情况：
 * T[-1][k][0] = 0, T[-1][k][1] = -Infinity
 * T[i][0][0] = 0, T[i][0][1] = -Infinity
 *
 * 状态转移方程：  max(休息，卖出/买入)
 * T[i][k][0] = max(T[i - 1][k][0], T[i - 1][k][1] + prices[i])
 * T[i][k][1] = max(T[i - 1][k][1], T[i - 1][k - 1][0] - prices[i])
 *
 * 最终答案：
 * T[n - 1][k][0]，因为结束时持有 0 份股票的收益一定大于持有 1 份股票的收益。
 *
 */
// 情况一：k = 1
public class DP121_templet1 {
    public int maxProfit(int[] prices) {
        int N = prices.length;
        int[][] dp = new int[N][2];
        // 参数2不变，只用到参数1，3
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < N; i++) {
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
            dp[i][1] = Math.max(dp[i-1][1],-prices[i]);
        }
        return dp[N-1][0];
    }
}
