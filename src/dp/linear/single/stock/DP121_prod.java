package dp.linear.single.stock;

public class DP121_prod {
    public int maxProfit(int[] prices) {
        int max = 0;
        for( int i = 0, j = 0; j < prices.length; j++ ){
            if(prices[j]<prices[i]) i = j;
            else max = Math.max(max,prices[j] - prices[i]);
        }
        return max;
    }
}
