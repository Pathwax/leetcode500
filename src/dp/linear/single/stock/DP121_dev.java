package dp.linear.single.stock;

public class DP121_dev {
    public int maxProfit(int[] prices) {
        int N = prices.length;
        int maxProfit = 0;
        int[][] dp = new int[N][N];
        for (int i = 0; i < prices.length; i++) {
            for (int j = i+1; j < prices.length; j++) {
                dp[i][j] = prices[j]-prices[i];
                maxProfit = Math.max(maxProfit,dp[i][j]);
            }
        }
        return maxProfit;
    }
}
