package dp.linear.single.houserobber;

public class DP198_dev {
    public int rob(int[] nums) {
        int len = nums.length;
        if (len == 0)
            return 0;
        if (len == 1)
            return nums[0];
        if (len == 2)
            return Math.max(nums[0],nums[1]);
        int[] dp = new int[len];
        dp[0] = nums[0];
        dp[1] = nums[1];
        int res = Math.max(dp[0],dp[1]);
        for (int i = 2; i < len; i++) {
            int max = 0;
            for (int j = 0; j < i-1; j++) {
                max = Math.max(max,dp[j]);
            }
            dp[i] = max+nums[i];
            if (dp[i]>res){
                res = dp[i];
            }
        }
        return res;
    }
}
