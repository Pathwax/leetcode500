package dp.linear.single.LIS;

public class DP53_dev {
    public int maxSubArray(int[] nums) {
        int temp = 0;
        int res = nums[0];
        for (int num : nums) {
            temp = temp>0?temp+num:num;
            res = Math.max(res,temp);
        }
        return res;
    }
}
