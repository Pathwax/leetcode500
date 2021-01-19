package dp.linear.single.withdimension;

import java.util.Arrays;

public class DP1478_prod {
    // TODO understand
    public int minDistance(int[] houses, int k) {
        int N = houses.length;
        Arrays.sort(houses);

        // rec[i][j] 表示从第i个房子到第j个房子，用一个邮箱的最小花费。
        // 这里预处理好所有的情况。
        int[][] rec = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                int mid = i + ( j - i ) / 2;
                for (int l = i; l <= j; l++) {
                    rec[i][j] += Math.abs(houses[l]-houses[mid]);
                }
            }
        }

        // dp[i][j] 表示i个数，j个邮局的最小划分方法。
        int[][] dp = new int[N][k+1];
        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i],Integer.MAX_VALUE);
            dp[i][1] = rec[0][i];
        }
        // 枚举最后一个邮箱负责的范围:
        // 最大的范围: 前j - 1 个邮箱各自负责一个房子，最后一个负责j - 1到i的所有房子
        // 最小的范围: 负责第i个房子。
        for (int i = 0; i < N; i++) {
            for (int j = 2; j <= Math.min(i+1,k); j++) {
                for (int l = j-1; l <= i; l++) {
                    dp[i][j] = Math.min(dp[i][j],dp[l-1][j-1]+rec[l][i]);
                }
            }
        }
        return dp[N-1][k];
    }
}
