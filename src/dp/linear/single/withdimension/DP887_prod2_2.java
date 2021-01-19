package dp.linear.single.withdimension;

public class DP887_prod2_2 {
    public int superEggDrop(int K, int N) {
        // dp[当前鸡蛋个数][最多允许的扔鸡蛋次数（所求结果）]=当前状态能确定的最高楼层数
        int[][] dp = new int[K+1][N+1];
        int res = 0;
        while(dp[K][res]<N){
            res++;
            for (int k = 1; k < K; k++) {
                // 总楼层数 = 楼上的楼层数+楼下的楼层数+1（当前这层楼）
                dp[k][res] = dp[k][res-1] + dp[k-1][res-1] + 1;
            }
        }
        return res;
    }
}
