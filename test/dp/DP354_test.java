package dp;

import dp.linear.single.LIS.DP354_dev;

public class DP354_test {
    public static void main(String[] args) {
        int[][] envelopes = new int[][]{{5,4},{6,4},{6,7},{2,3}};
        DP354_dev dev = new DP354_dev();
        dev.maxEnvelopes(envelopes);
    }
}
