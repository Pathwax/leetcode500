package dp.linear.single.stock_templet;

public class DP714_templet2 {
    public int maxProfit(int[] prices, int fee) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int profit0 = 0, profit1 = -prices[0];
        int N = prices.length;
        for (int i = 1; i < N; i++) {
            int newProfit0 = Math.max(profit0, profit1 + prices[i] - fee);
            int newProfit1 = Math.max(profit1, profit0 - prices[i]);
            profit0 = newProfit0;
            profit1 = newProfit1;
        }
        return profit0;
    }
}
