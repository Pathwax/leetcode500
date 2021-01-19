import java.util.Arrays;

public class DP887_test2 {
    public static int superEggDrop(int K, int N) {
        int[][] dp = new int[K+1][N+1];
        for (int i = 1; i < K + 1; i++) {
            Arrays.fill(dp[i],Integer.MAX_VALUE);
        }
        int res = Integer.MAX_VALUE;
        int i = 1, j = 1;
        for (int k = 0; k <= N; k++) {
            for ( ; i <= N; i++) {
                for ( ; j <= K; j++) {
                    if (j==1) {
                        dp[j][i] = i;
                        continue;
                    }
                    dp[j][i] = Math.min(dp[j][i],Math.max(dp[j-1][i-1],dp[j][N-i])+1);
                }
            }
            if (dp[j][i]<res) res = dp[j][i];
        }

        return res;
    }

    public static void main(String[] args) {
        DP887_test2.superEggDrop(1,2);
    }
}
