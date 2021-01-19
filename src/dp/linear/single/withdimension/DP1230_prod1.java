package dp.linear.single.withdimension;

public class DP1230_prod1 {
    public double probabilityOfHeads(double[] prob, int target) {
        int N = prob.length;
        // dp[i][j]表示抛完第i枚后，有j个朝上的概率
        double[][] dp = new double[N+1][target+1];
        dp[0][0] = 1.0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j <= Math.min(i, target); j++) {
                dp[i+1][j] += dp[i][j] * (1-prob[i]);// 下一枚是反面
                if (j+1<=target)
                    dp[i+1][j+1] += dp[i][j] * prob[i];// 下一枚是正面
            }
        }
        return dp[N][target];
    }
}
