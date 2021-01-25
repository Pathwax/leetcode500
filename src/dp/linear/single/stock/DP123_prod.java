package dp.linear.single.stock;

public class DP123_prod {
    public int maxProfit(int[] prices) {
        int onceProfit1 = Integer.MIN_VALUE,
                onceProfit0 = 0,
                twiceProfit1 = Integer.MIN_VALUE,
                twiceProfit0 = 0;
        for (int p : prices) {
            if (-p > onceProfit1)
                onceProfit1 = -p;
            if (onceProfit0 < p + onceProfit1) onceProfit0 = p + onceProfit1;
            if (twiceProfit1 < onceProfit0 - p) twiceProfit1 = onceProfit0 - p;
            if (twiceProfit0 < twiceProfit1 + p) twiceProfit0 = twiceProfit1 + p;
        }
        return twiceProfit0;
    }
}
