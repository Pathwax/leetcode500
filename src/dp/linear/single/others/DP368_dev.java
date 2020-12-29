package dp.linear.single.others;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DP368_dev {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);
        int max = 0;
        int tagIndex = 0;
        for (int i = 1; i < nums.length; i++) {
            for (int j = i-1; j >= 0; j--) {
                if (nums[i]%nums[j]==0&&dp[i]<=dp[j]){
                    int temp = max;
                    dp[i] = dp[j]+1;
                    max = Math.max(max,dp[i]);
                    if (temp!=max)
                        tagIndex = i;
                }
            }
        }
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = tagIndex; i >=0 ; i--) {
            if (nums[tagIndex]%nums[i] == 0 && dp[i] == max){
                res.add(nums[i]);
                max--;
                if (max==0) break;
            }
        }
        return res;
    }
}
