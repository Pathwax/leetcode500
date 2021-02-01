package dp.knapsack.bestvalue;

//转换成01背包问题，求两堆石头的最小差值。由于石头总和为sum.则问题转换成了
//背包最多装sum / 2的石头,stones数组里有一大堆石头。求如何装能装下最多重量石头。
public class DP1049_prod {
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for (int stone : stones) {
            sum += stone;
        }
        int[] dp = new int[sum/2+1];
        for (int stone : stones) {
            for (int i = sum/2; i >= stone; i--) {
                dp[i] = Math.max(dp[i],dp[i-stone]+stone);
            }
        }
        return (sum-dp[sum/2])-dp[sum/2];
    }
}
