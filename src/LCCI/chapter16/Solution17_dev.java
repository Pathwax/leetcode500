package LCCI.chapter16;

public class Solution17_dev {
    public int maxSubArray(int[] nums) {
        // dp[i]:以i索引结尾的连续数列的最大总和。
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i]=dp[i-1]>0?dp[i-1]+nums[i]:nums[i];
            if (dp[i]>max)
                max = dp[i];
        }
        return max;
    }
}
