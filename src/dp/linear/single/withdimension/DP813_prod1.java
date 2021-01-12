package dp.linear.single.withdimension;

public class DP813_prod1 {
    public double largestSumOfAverages(int[] A, int K) {
        int N = A.length;
        // 前缀和数组, A数组从0开始前i位数的和
        double[] P = new double[N+1];
        P[0] = 0;
        for (int i = 0; i < N; i++) {
            P[i+1] = P[i]+A[i];
        }
        double[] dp = new double[N];
        // 第一次dp，dp[i]表示A数组下标[i,...,N-1]分为一个非空连续子数组的平均值
        for (int i = 0; i < N; i++) {
            dp[i] = (P[N]-P[i])/(N-i);
        }
        // 第二次到第k次dp。k = 1代表第二次，k = 2代表第三次，以此类推，k = K-1代表第k次。
        for (int k = 1; k < K; k++) {
            // 先把i固定，j变化作为分割点
            // 分隔一次i-(N-1)变为两个连续数组
            // 分隔两次变为3个连续数组
            // 分隔K-1次变为K个连续数组
            for (int i = 0; i < N; i++) {
                for (int j = i+1; j < N; j++) {
                    dp[i] = Math.max(dp[i],dp[j]+(P[j]-P[i])/(j-i));
                }
            }
        }
        return dp[0];
    }
}
