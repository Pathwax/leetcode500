package dp.linear.single.LIS;

import java.util.Arrays;

public class DP354_dev {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes,(o1, o2) -> o1[0]==o2[0]?o2[1]-o1[1]:o1[0]-o2[0]);
        int[] dp = new int[envelopes.length];
        Arrays.fill(dp,1);
        int res = 0;
        for (int i = 0; i < envelopes.length; i++) {
            for (int j = 0; j < i; j++) {
                if (envelopes[j][1]<envelopes[i][1])
                    dp[i] = Math.max(dp[i],dp[j] + 1 );
            }
            res = Math.max(res,dp[i]);
        }
        return res;
    }
}
