package dp.linear.single.withdimension;

public class DP887_prod2 {
    public int superEggDrop(int K, int N) {
        int[] dp = new int[K+1];
        int ans = 0;
        while(dp[K]<N){
            for (int i = K; i > 0; i--)
                dp[i] = dp[i] + dp[i-1] + 1;
            ans++;
        }
        return ans;
    }
}
