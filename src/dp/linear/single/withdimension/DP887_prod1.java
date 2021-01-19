package dp.linear.single.withdimension;

import java.util.Arrays;

public class DP887_prod1 {
    public int superEggDrop(int K, int N) {
        int[][] dp = new int[N+1][K+1];
        for (int i = 0; i < N + 1; i++) {
            Arrays.fill(dp[i],i);
        }
        for (int i = 0; i < N+1; i++) {
            dp[i][0] = 0;
            dp[i][1] = i;
        }
        for (int j = 2 ; j <= K; j++) {
            for (int i = 2 ; i <= N; i++) {
                // 初始选择的楼层在[1,i]里用二分法确定一个最优值
                int left = 1, right = i;
                while(left<right){
                    // 找dp[k-1][j-1] <= dp[i-mid][j]的最大值k
                    int mid = left + (right-left+1)/2;
                    int breakCount = dp[mid-1][j-1];
                    int notBreakCount = dp[i-mid][j];
                    if (breakCount>notBreakCount)
                        right = mid - 1;
                    else
                        left = mid;
                }
                dp[i][j] = Math.max(dp[left-1][j-1],dp[i-left][j])+1;
            }
        }
        return dp[N][K];
    }
}
