package dp.linear.single.stock_templet;

public class DP188_templet2 {
    public int maxProfit(int k, int[] prices) {
        if(prices==null||prices.length==0)
            return 0;
        int N = prices.length;
        // 每天都交易时已经是最大，允许最大交易量再大也无关紧要
        if(k>=N/2) return maxProfit(prices);
        int[][] dp = new int[k+1][2];
        for(int i = 0; i <= k; i++){
            dp[i][0] = 0;
            dp[i][1] = -prices[0];
        }
        for(int i = 1; i < N; i++){
            for(int j = k; j > 0;j--){
                dp[j][0] = Math.max(dp[j][0],dp[j][1]+prices[i]);
                dp[j][1] = Math.max(dp[j][1],dp[j-1][0]-prices[i]);
            }
        }
        return dp[k][0];
    }
    // 情况二
    private int maxProfit(int[] prices){
        int N = prices.length;
        int profit0 = 0;
        int profit1 = -prices[0];
        for(int i = 1; i < N; i++){
            int temp = profit0;
            profit0 = Math.max(profit0,profit1+prices[i]);
            profit1 = Math.max(profit1,temp-prices[i]);
        }
        return profit0;
    }
}
