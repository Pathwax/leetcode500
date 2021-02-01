package dp.knapsack.conbination;

/**
 * 原来的问题已转化为一个求子集的和问题： 找到nums的一个子集 P，使得
 * sum(P)=target+sum(nums)/2
 *
 * https://leetcode-cn.com/problems/target-sum/solution/python-dfs-xiang-jie-by-jimmy00745/
 */
public class DP494_prod {
    public int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for(int num: nums){
            sum+=num;
        }
        if ((sum+S)%2==1 || sum < S) return 0;
        int[] dp = new int[(sum+S)/2+1];
        dp[0] = 1;
        for(int num:nums){
            for (int i = (sum+S)/2; i >= num; i--) {
                dp[i] += dp[i-num];
            }
        }
        return dp[(sum+S)/2];
    }
}
