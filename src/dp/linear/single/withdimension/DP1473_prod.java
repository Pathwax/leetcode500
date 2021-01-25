package dp.linear.single.withdimension;

import java.util.Arrays;

public class DP1473_prod {
    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        // dp[i][j][k] 涂完前i个房子，目前有j个街区，且第i个房子的颜色为k的所有方案 cost最小的。
        // 房子从0开始，街区从1开始，颜色从1开始
        final int INF = 1_000_001;
        int[][][] dp = new int[m+1][target+1][n+1];
        for (int i = 0; i < m + 1; i++) {
            for (int j = 0; j < target + 1; j++) {
                Arrays.fill(dp[i][j],INF);
            }
        }
        // 初始化第0个房子
        // 第0个房子已经涂色
        if (houses[0] > 0) dp[0][1][houses[0]] = 0;
            // 第0个房子没有涂色
        else System.arraycopy(cost[0], 0, dp[0][1], 1, n);
        // 状态转移时涂完第i个房子
        for (int i = 1; i < m; i++) {
            // 最多target个街区
            for (int j = 1; j <= target; j++) {
                // 分成第i个房子是否涂色
                if (houses[i] > 0){
                    int curColor = houses[i];
                    for (int k = 1; k <= n; k++) {
                        // 分成第i个房子和第i-1的房子
                        // 如果两个房子颜色相同，那么街区数就相同
                        // 如果两个房子颜色不同，那么第i个房子就独自成一个街区
                        if (curColor==k)
                            dp[i][j][curColor] = Math.min(dp[i][j][curColor],dp[i-1][j][k]);
                        else
                            dp[i][j][curColor] = Math.min(dp[i][j][curColor],dp[i-1][j-1][k]);
                    }
                }else{
                    for (int k = 1; k <= n; k++) {
                        for (int l = 1; l <= n; l++) {
                            if (k==l)
                                dp[i][j][k] = Math.min(dp[i][j][k],dp[i-1][j][l] + cost[i][k-1]);
                            else
                                dp[i][j][k] = Math.min(dp[i][j][k],dp[i-1][j-1][l] + cost[i][k-1]);
                        }
                    }
                }
            }
        }
        int res = INF;
        for (int color = 1; color <= n; color++) {
            res = Math.min(res,dp[m-1][target][color]);
        }
        return res == INF ? -1 : res;
    }
}
