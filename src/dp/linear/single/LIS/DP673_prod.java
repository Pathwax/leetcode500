package dp.linear.single.LIS;

import java.util.Arrays;

public class DP673_prod {
    public int findNumberOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int[] counter = new int[nums.length];
        Arrays.fill(dp,1);
        Arrays.fill(counter,1);
        int LISLength = 0;
        for(int i = 0;i<nums.length;i++){
            for(int j = 0;j<i;j++){
                if(nums[j]<nums[i]){
                    if(dp[j]+1>dp[i]){
                        dp[i] = dp[j] + 1;
                        counter[i] = counter[j];
                    }else if(dp[j]+1==dp[i])
                        counter[i] += counter[j];
                }
            }
            LISLength = Math.max(LISLength,dp[i]);
        }
        int res = 0;
        for(int i = 0;i<nums.length;i++)
            if(dp[i]==LISLength) res+=counter[i];
        return res;
    }
}
