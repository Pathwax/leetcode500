package dp.knapsack.conbination;

/**
 * 空间压缩时，k>=0而不是k>=P，我们可以看到dp[j][k]+=dp[j-g][max(k-p,0)]，
 * 这是因为在剩余所需的利益k小于当前罪行带来的p时，坐标可能小于0，但是这种情况依然是满足条件的
 */
public class DP879_prod {
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        int len = group.length;
        final int M = 1_000_000_007;
        int[][] dp = new int[n+1][minProfit+1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= len; i++) {
            int g = group[i-1];
            int p = profit[i-1];
            for (int j = n; j >= g; j--) {
                for (int k = minProfit; k >= 0; k--) {
                    dp[j][k] += dp[j-g][Math.max(k-p,0)];
                    dp[j][k] %= M;
                }
            }
        }
        return dp[n][minProfit];
    }
}
