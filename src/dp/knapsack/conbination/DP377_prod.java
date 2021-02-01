package dp.knapsack.conbination;

/**
 * 背包问题具备的特征：给定一个target，再给定一个数组nums，问：能否使用nums中的元素做各种排列组合得到target。
 *
 * 组合问题公式
 * dp[i] += dp[i-num]
 * True、False问题公式
 * dp[i] = dp[i] or dp[i-num]
 * 最大最小问题公式
 * dp[i] = min(dp[i], dp[i-num]+1)或者dp[i] = max(dp[i], dp[i-num]+1)
 *
 * 技巧
 * 1.如果是0-1背包，即数组中的元素不可重复使用，nums放在外循环，target在内循环，且内循环倒序；
 * for num in nums:
 *     for i in range(target, nums-1, -1):
 * 2.如果是完全背包，即数组中的元素可重复使用，nums放在外循环，target在内循环。且内循环正序。
 * for num in nums:
 *     for i in range(nums, target+1):
 * 3.如果组合问题需考虑元素之间的顺序，需将target放在外循环，将nums放在内循环。
 * for i in range(1, target+1):
 *     for num in nums:
 * 4.不超过、恰好的区别存在于赋初值的时候。
 */
public class DP377_prod {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target+1];
        dp[0] = 1;
        for(int i = 1; i <= target; i++){
            for(int num: nums){
                if(i-num>=0){
                    dp[i] += dp[i-num];
                }
            }
        }
        return dp[target];
    }
}
