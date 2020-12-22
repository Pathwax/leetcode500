package dp.linear.single.maxsubarray;

public class DP152_prod {
    public int maxProduct(int[] nums) {
        if (nums.length==0) return 0;
        int pre_max = nums[0];
        int pre_min = nums[0];
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int cur_max = Math.max(Math.max(pre_max*nums[i],pre_min*nums[i]),nums[i]);
            int cur_min = Math.min(Math.min(pre_max*nums[i],pre_min*nums[i]),nums[i]);
            res = Math.max(res,cur_max);
            pre_max = cur_max;
            pre_min = cur_min;
        }
        return res;
    }
}
