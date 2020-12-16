package dp.linear.single.LIS;

public class DP300_dev {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int res = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j]<nums[i])
                    dp[i] = dp[j] + 1 > dp[i] ? dp[j] + 1 : dp[i];
            }
            if (dp[i]>res)
                res = dp[i];
        }
        return res;
    }
}
