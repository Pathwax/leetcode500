package dp.linear.single.stock_templet;

// 情况二：k = +∞。参数1中i只与i-1有关，降维。
public class DP122_templet2 {
    public int maxProfit(int[] prices) {
        int N = prices.length;
        int profit0 = 0;
        int profit1 = -prices[0];
        for (int i = 1; i < N; i++) {
            int temp = profit0;
            profit0 = Math.max(profit0,profit1 + prices[i]);
            profit1 = Math.max(profit1,temp - prices[i]);
        }
        return profit0;
    }
}
