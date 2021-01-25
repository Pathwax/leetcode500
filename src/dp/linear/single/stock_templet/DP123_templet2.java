package dp.linear.single.stock_templet;

public class DP123_templet2 {
    public int maxProfit(int[] prices) {
        int N = prices.length;
        int onceProfit0 = 0;
        int onceProfit1 = -prices[0];
        int twiceProfit0 = 0;
        int twiceProfit1 = -prices[0];
        for (int i = 1; i < N; i++) {
            int temp = onceProfit0;
            onceProfit0 = Math.max(onceProfit0, onceProfit1 + prices[i]);
            onceProfit1 = Math.max(onceProfit1, -prices[i]);
            twiceProfit0 = Math.max(twiceProfit0, twiceProfit1 + prices[i]);
            twiceProfit1 = Math.max(twiceProfit1, temp - prices[i]);
        }
        return twiceProfit0;
    }
}
