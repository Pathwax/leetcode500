package dp.linear.single.stock_templet;

// 情况一：k = 1。参数1中i只与i-1有关，降维。
public class DP121_templet2 {
    public int maxProfit(int[] prices) {
        int profit0 = 0;
        int profit1 = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            profit0 = Math.max(profit0,profit1+prices[i]);
            profit1 = Math.max(profit1,-prices[i]);
        }
        return profit0;
    }
}
